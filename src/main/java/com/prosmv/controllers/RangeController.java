package com.prosmv.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.domain.Category;
import com.prosmv.domain.Factory;
import com.prosmv.domain.GridSize;
import com.prosmv.domain.Range;
import com.prosmv.domain.Size;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.CategoryForm;
import com.prosmv.form.RangeForm;
import com.prosmv.form.model.FactoryIdModel;
import com.prosmv.form.model.GridSizeIdModel;
import com.prosmv.service.helper.StyleHelperService;
import com.prosmv.util.ResponseHandler;

@RestController
public class RangeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RangeController.class);
	
	@Autowired
	private StyleHelperService styleHelperService;

	@GetMapping(value = ApiUrl.AUTO_COMPLETE_RANGE)
	public ResponseEntity<ResponseDTO> getAutoCompleteRange(@RequestParam String rangeName,
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				styleHelperService.getAutoCompleteRange(rangeName, factoryIdModel.getFactoryId()));
	}

	@PostMapping(value = ApiUrl.CREATE_RANGE)
	public ResponseEntity<ResponseDTO> createRange(@Validated(value = ValidateSequence.class) @RequestBody RangeForm rangeForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(styleHelperService.createRange(rangeForm));
	}

	@PostMapping(value = ApiUrl.CREATE_CATEGORY)
	public ResponseEntity<ResponseDTO> createCategory(@Validated(value = ValidateSequence.class) @RequestBody CategoryForm categoryForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(styleHelperService.createCategory(categoryForm));
	}

	/**
	 * This api end point is used to get all {@link Range} by factoryId.
	 * 
	 * @param factoryIdModel {@link FactoryIdModel}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_RANGE_BY_FACTORY)
	public ResponseEntity<ResponseDTO> getRangeByFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(styleHelperService.getRangeByFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to get all {@link Category} by {@link Factory}.
	 * 
	 * @param factoryIdModel {@link FactoryIdModel}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_CATEGORY_BY_FACTORY)
	public ResponseEntity<ResponseDTO> getCategoryByFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(styleHelperService.getCategoryByFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to get all {@link GridSize} based on
	 * {@link Factory}.
	 * 
	 * @param factoryIdModel {@link FactoryIdModel}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_SIZE_GRID_BY_FACTORY)
	public ResponseEntity<ResponseDTO> getSizeGridByFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(styleHelperService.getSizeGridByFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to get all {@link Size} by {@link GridSize}.
	 * 
	 * @param gridSizeIdModel {@link GridSizeIdModel}
	 * @param bindingResult   {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_SIZE_BY_GRID_SIZE)
	public ResponseEntity<ResponseDTO> getSizeByGridSize(
			@Validated(value = ValidateSequence.class) @ModelAttribute GridSizeIdModel gridSizeIdModel,
			BindingResult bindingResult) {
		LOGGER.info("api executing and grid sizeid {} ",gridSizeIdModel.getGridSizeId());
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(styleHelperService.getSizeByGridSize(gridSizeIdModel.getGridSizeId()));
	}

}
