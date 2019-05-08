package com.prosmv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.MachineForm;
import com.prosmv.form.model.FactoryIdModel;
import com.prosmv.form.model.MachineIdModel;
import com.prosmv.service.helper.MachineHelperService;
import com.prosmv.util.ResponseHandler;

@CrossOrigin
@RestController
public class MachineController {

	@Autowired
	private MachineHelperService machineHelperService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping(value = ApiUrl.CREATE_MACHINE)
	public ResponseEntity<ResponseDTO> createMachine(
			@Validated(value = ValidateSequence.class) @RequestBody MachineForm machineForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(machineHelperService.createMachine(machineForm));
	}

	@PutMapping(value = ApiUrl.UPDATE_MACHINE)
	public ResponseEntity<ResponseDTO> updateMachine(
			@Validated(value = ValidateSequence.class) @ModelAttribute MachineIdModel machineIdModel,
			BindingResult bindingResult1,
			@Validated(value = ValidateSequence.class) @RequestBody MachineForm machineForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		if (bindingResult1.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult1.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				machineHelperService.updateMachine(machineForm, machineIdModel.getMachineId()));
	}

	@DeleteMapping(value = ApiUrl.DELETE_MACHINE)
	public ResponseEntity<ResponseDTO> deleteMachine(
			@Validated(value = ValidateSequence.class) @ModelAttribute MachineIdModel machineIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(machineHelperService.deleteMachine(machineIdModel.getMachineId()));
	}

	@GetMapping(value = ApiUrl.GET_ALL_MACHINES)
	public ResponseEntity<ResponseDTO> getAllMachines(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("Validation failed while deleting brand for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(machineHelperService.getAllMachines(factoryIdModel.getFactoryId()));
	}

	@GetMapping(value = ApiUrl.GET_USER_MACHINES)
	public ResponseEntity<ResponseDTO> getUserMachines() {
		return ResponseHandler.generateControllerResponse(machineHelperService.getUserMachines());
	}
}
