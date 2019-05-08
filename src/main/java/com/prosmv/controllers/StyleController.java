package com.prosmv.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.StyleForm;
import com.prosmv.form.model.FactoryIdModel;
import com.prosmv.form.model.MachineIdModel;
import com.prosmv.form.model.StyleIdModel;
import com.prosmv.service.helper.StyleHelperService;
import com.prosmv.util.ResponseHandler;

@RestController
public class StyleController {

	@Autowired
	StyleHelperService styleHelperService;

	@PostMapping(value = ApiUrl.CREATE_STYLE)
	public ResponseEntity<ResponseDTO> createStyle(@Valid @RequestBody StyleForm styleForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(styleHelperService.createStyle(styleForm));
	}

	@PostMapping(value = ApiUrl.UPDATE_STYLE)
	public ResponseEntity<ResponseDTO> updateteStyle(
			@Validated(value = ValidateSequence.class) @ModelAttribute StyleIdModel styleIdModel,
			BindingResult bindingResult1, @Validated(value = ValidateSequence.class) @RequestBody StyleForm styleForm,
			BindingResult bindingResult) {
		if (bindingResult1.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult1.getAllErrors().get(0).getDefaultMessage());
		}
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(styleHelperService.updateStyle(styleForm, styleIdModel.getStyleId()));
	}

	@DeleteMapping(value = ApiUrl.DELETE_STYLE)
	public ResponseEntity<ResponseDTO> deleteStyle(@ModelAttribute StyleIdModel styleIdModel) {
		return ResponseHandler.generateControllerResponse(styleHelperService.deleteStyle(styleIdModel.getStyleId()));
	}

	@GetMapping(value = ApiUrl.GET_ALL_STYLES)
	public ResponseEntity<ResponseDTO> getAllStyles(@ModelAttribute FactoryIdModel factoryIdModel) {
		return ResponseHandler
				.generateControllerResponse(styleHelperService.getAllStyles(factoryIdModel.getFactoryId()));
	}

	@GetMapping(value = ApiUrl.GET_USER_STYLES)
	public ResponseEntity<ResponseDTO> getUserStyles() {
		ResponseEntity<ResponseDTO>  response = null;
		//System.out.println("data is "+ResponseHandler.generateControllerResponse(styleHelperService.getUserStyles()).getBody());
		response = ResponseHandler.generateControllerResponse(styleHelperService.getUserStyles());
		return response;
	}

	@DeleteMapping(value = ApiUrl.SET_STYLE_STATUS)
	public ResponseEntity<ResponseDTO> setStyleStatus(@RequestParam Long styleId, @RequestParam boolean active) {
		return ResponseHandler.generateControllerResponse(styleHelperService.setStyleStatus(styleId, active));
	}

	@GetMapping(value = ApiUrl.AUTO_COMPLETE_STYLE)
	public ResponseEntity<ResponseDTO> getAutoCompleteStyle(@RequestParam String styleName,
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				styleHelperService.getAutoCompleteStyle(styleName, factoryIdModel.getFactoryId()));
	}

	@GetMapping(value = ApiUrl.AUTO_COMPLETE_CATEGORY)
	public ResponseEntity<ResponseDTO> getAutoCompleteCategory(@RequestParam String categoryName,
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				styleHelperService.getAutoCompleteCategory(categoryName, factoryIdModel.getFactoryId()));
	}
	
	@GetMapping(value = ApiUrl.AUTO_COMPLETE_GRID_SIZE)
	public ResponseEntity<ResponseDTO> getAutoCompleteGridSize(@RequestParam String gridSizeName,
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				styleHelperService.getAutoCompleteGridSize(gridSizeName, factoryIdModel.getFactoryId()));
	}
}
