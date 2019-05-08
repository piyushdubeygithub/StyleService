package com.prosmv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.SizeForm;
import com.prosmv.form.SizeGridForm;
import com.prosmv.service.helper.StyleHelperService;
import com.prosmv.util.ResponseHandler;

@RestController
public class SizeGridController {
	
	@Autowired
	StyleHelperService styleHelperService;

	@PostMapping(value = ApiUrl.CREATE_SIZE_GRID)
	public ResponseEntity<ResponseDTO> createSizeGrid(@Validated(value = ValidateSequence.class) @RequestBody SizeGridForm sizeGridForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(styleHelperService.createSizeGrid(sizeGridForm));
	}
	
	@PostMapping(value = ApiUrl.CREATE_SIZE)
	public ResponseEntity<ResponseDTO> createSize(@Validated(value = ValidateSequence.class) @RequestBody SizeForm sizeForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(styleHelperService.createSize(sizeForm));
	}

}
