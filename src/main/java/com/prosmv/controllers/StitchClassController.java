package com.prosmv.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.StitchClassForm;
import com.prosmv.service.helper.StitchClassHelperService;
import com.prosmv.util.ResponseHandler;

@RestController
public class StitchClassController {

	@Autowired
	StitchClassHelperService stitchClassHelperService;

	@PostMapping(value= ApiUrl.CREATE_STITCHCLASS)
	public ResponseEntity<ResponseDTO> createStitchClass(@Valid @RequestBody StitchClassForm stitchClassForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(stitchClassHelperService.saveStitchClass(stitchClassForm));
	}

	@PutMapping(value = ApiUrl.UPDATE_STITCHCLASS)
	public ResponseEntity<ResponseDTO> updateStitchClass(@Valid @RequestBody StitchClassForm stitchClassForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(stitchClassHelperService.updateStitchClass(stitchClassForm));
	}

	@GetMapping(value = ApiUrl.GET_ALL_STITCHCLASSES)
	public ResponseEntity<ResponseDTO> getStitchClasses(@RequestParam Long factoryId) {
		return ResponseHandler.generateControllerResponse(stitchClassHelperService.getAllStitchClass(factoryId));
	}

	@DeleteMapping(value = ApiUrl.DELETE_STITCHCLASS)
	public ResponseEntity<ResponseDTO> deleteStitchClass(@RequestParam Long stitchClassId) {
		return ResponseHandler.generateControllerResponse(stitchClassHelperService.deleteStitchClass(stitchClassId));
	}
	
	@GetMapping(value = ApiUrl.GET_USER_STITCHCLASSES)
	public ResponseEntity<ResponseDTO> getUserStitchClasses() {
		return ResponseHandler.generateControllerResponse(stitchClassHelperService.getUserStitchClasses());
	}
}
