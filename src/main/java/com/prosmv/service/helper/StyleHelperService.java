package com.prosmv.service.helper;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Category;
import com.prosmv.domain.Factory;
import com.prosmv.domain.GridSize;
import com.prosmv.domain.Range;
import com.prosmv.domain.Size;
import com.prosmv.dto.CategoryDTO;
import com.prosmv.dto.GridSizeDTO;
import com.prosmv.dto.RangeDTO;
import com.prosmv.dto.SizeDTO;
import com.prosmv.dto.StyleDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.StyleException;
import com.prosmv.form.CategoryForm;
import com.prosmv.form.RangeForm;
import com.prosmv.form.SizeForm;
import com.prosmv.form.SizeGridForm;
import com.prosmv.form.StyleForm;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.service.StyleService;
import com.prosmv.util.GenericUtils;
import com.prosmv.util.ResponseHandler;

/**
 * This Service class is used for style service responses send to controller.
 * 
 * @author piyush
 *
 */

@Service
public class StyleHelperService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StyleHelperService.class);
	
	@Autowired
	private StyleService styleService;

	@Autowired
	private FactoryRepository factoryRepository;
	
	public ResponseDTO createStyle(StyleForm styleForm) {
		try {
			styleService.createStyle(styleForm);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_CREATE_STYLE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STYLE_CREATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	public ResponseDTO updateStyle(StyleForm styleForm, Long styleId) {
		try {
			styleService.updateStyle(styleForm, styleId);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_UPDATE_STYLE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STYLE_UPDATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	public ResponseDTO deleteStyle(Long styleId) {
		try {
			styleService.deleteStyle(styleId);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_DELETE_STYLE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STYLE_DELETED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	public ResponseDTO getAllStyles(Long factoryId) {
		List<StyleDTO> styleDTOs = styleService.getAllStyles(factoryId);
		return ResponseHandler.generateServiceResponse(styleDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO setStyleStatus(Long styleId, boolean active) {
		try {
			styleService.setStyleStatus(styleId, active);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_SET_STYLE_STATUS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO getAutoCompleteStyle(String styleName, Long factoryId) {
		List<StyleDTO> styleDTOs = styleService.getAutoCompleteStyle(styleName, factoryId);
		return ResponseHandler.generateServiceResponse(styleDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO getUserStyles() {
		List<StyleDTO> styleDTOs = styleService.getUserStyles();
		LOGGER.info("Style list size is {} ",styleDTOs.size());
		styleDTOs.forEach(styleDto->{
			LOGGER.info("Style dto json is {} ",styleDto.toString());
		});
		return ResponseHandler.generateServiceResponse(styleDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO getAutoCompleteRange(String rangeName, Long factoryId) {
		List<RangeDTO> rangeDTOs = styleService.getAutoCompleteRange(rangeName, factoryId);
		return ResponseHandler.generateServiceResponse(rangeDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO getAutoCompleteCategory(String categoryName, Long factoryId) {
		List<CategoryDTO> categoryDTOs = styleService.getAutoCompleteCategory(categoryName, factoryId);
		return ResponseHandler.generateServiceResponse(categoryDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO getAutoCompleteGridSize(String gridSizeName, Long factoryId) {
		List<GridSizeDTO> categoryDTOs = styleService.getAutoCompleteGridSize(gridSizeName, factoryId);
		return ResponseHandler.generateServiceResponse(categoryDTOs, ServiceMessageCode.STYLE_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO createSizeGrid(SizeGridForm sizeGridForm) {
		try {
			styleService.createSizeGrid(getSizeGridObject(sizeGridForm));
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_CREATE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CREATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	private GridSize getSizeGridObject(SizeGridForm sizeGridForm) {
		GridSize gridSize = new GridSize();
		gridSize.setActive('Y');
		gridSize.setCreatedBy(GenericUtils.getLoggedInUser());
		gridSize.setDeleted('N');
		gridSize.setFactory(factoryRepository.findById(sizeGridForm.getFactoryId()));
		gridSize.setGridValue(sizeGridForm.getGridValue());
		gridSize.setUpdatedBy(GenericUtils.getLoggedInUser());
		return gridSize;
	}

	public ResponseDTO createSize(SizeForm sizeForm) {
		try {
			styleService.createSize(sizeForm);
		} catch (Exception exception) {
			LOGGER.info(exception.getMessage());
			throw new StyleException(ServiceMessageCode.UNABLE_TO_CREATE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CREATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	public ResponseDTO createRange(RangeForm rangeForm) {
		try {
			styleService.createRange(getRangeObject(rangeForm));
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_CREATE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CREATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	private Range getRangeObject(RangeForm rangeForm) {
		Range range = new Range();
		range.setActive('Y');
		range.setCreatedBy(GenericUtils.getLoggedInUser());
		range.setDeleted('N');
		range.setFactory(factoryRepository.findById(rangeForm.getFactoryId()));
		range.setName(rangeForm.getName());
		range.setUpdatedBy(GenericUtils.getLoggedInUser());
		return range;
	}

	public ResponseDTO createCategory(CategoryForm categoryForm) {
		try {
			styleService.createCategory(getCategoryObject(categoryForm));
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_CREATE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CREATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	private Category getCategoryObject(CategoryForm categoryForm) {
		Category category = new Category();
		category.setActive('Y');
		category.setCreatedBy(GenericUtils.getLoggedInUser());
		category.setDeleted('N');
		category.setFactory(factoryRepository.findById(categoryForm.getFactoryId()));
		category.setName(categoryForm.getName());
		category.setUpdatedBy(GenericUtils.getLoggedInUser());
		return category;
	}

	/**
	 * This helper method is used to get all {@link Range} by {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getRangeByFactory(Long factoryId) {
		try {
			List<RangeDTO> rangeDTOs = styleService.getRangeByFactory(factoryId);
			if (rangeDTOs.isEmpty()) {
				return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.RANGE_LIST_EMPTY, null, true,
						HttpStatus.OK);
			}
			return ResponseHandler.generateServiceResponse(rangeDTOs, ServiceMessageCode.RANGE_FETCHED_SUCCESSFULLY,
					null, true, HttpStatus.OK);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_GET_RANGE);
		}
	}

	/**
	 * This helper method is used to get all {@link Category} by {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getCategoryByFactory(Long factoryId) {
		try {
			List<CategoryDTO> categoryDTOs = styleService.getCategoryByFactory(factoryId);
			if (categoryDTOs.isEmpty()) {
				return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CATEGORY_LIST_EMPTY, null, true,
						HttpStatus.OK);
			}
			return ResponseHandler.generateServiceResponse(categoryDTOs,
					ServiceMessageCode.CATEGORY_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_GET_CATEGORY);
		}
	}

	/**
	 * This helper method is used to get all {@link GridSize} based on
	 * {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getSizeGridByFactory(Long factoryId) {
		try {
			List<GridSizeDTO> gridSizeDTOs = styleService.getSizeGridByFactory(factoryId);
			if (gridSizeDTOs.isEmpty()) {
				return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.GRID_SIZE_LIST_EMPTY, null,
						true, HttpStatus.OK);
			}
			return ResponseHandler.generateServiceResponse(gridSizeDTOs,
					ServiceMessageCode.GRID_SIZE_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_GET_GRID_SIZE);
		}
	}

	/**
	 * This helper method is used to get all {@link Size} by {@link GridSize}.
	 * 
	 * @param gridSizeId id of {@link GridSize}.
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getSizeByGridSize(Long gridSizeId) {
		try {
			List<SizeDTO> sizeList = styleService.getSizeByGridSize(gridSizeId);
			sizeList.forEach(size->{
				LOGGER.info("sizedto {} {} {} ",size.getId(),size.getSizeValue(),size.getSizeDescription());
			});
			if (sizeList.isEmpty()) {
				return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.SIZE_LIST_EMPTY, null, true,
						HttpStatus.OK);
			}
			return ResponseHandler.generateServiceResponse(sizeList, ServiceMessageCode.SIZE_FETCHED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception exception) {
			throw new StyleException(ServiceMessageCode.UNABLE_TO_GET_SIZE);
		}
	}

}
