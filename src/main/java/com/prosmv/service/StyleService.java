package com.prosmv.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Brand;
import com.prosmv.domain.Category;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;
import com.prosmv.domain.GridSize;
import com.prosmv.domain.Range;
import com.prosmv.domain.Size;
import com.prosmv.domain.Style;
import com.prosmv.domain.User;
import com.prosmv.dto.CategoryDTO;
import com.prosmv.dto.GridSizeDTO;
import com.prosmv.dto.RangeDTO;
import com.prosmv.dto.SizeDTO;
import com.prosmv.dto.StyleDTO;
import com.prosmv.form.SizeForm;
import com.prosmv.form.StyleForm;
import com.prosmv.repositories.BrandRepository;
import com.prosmv.repositories.CategoryRepository;
import com.prosmv.repositories.CustomerRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.GridSizeRepository;
import com.prosmv.repositories.RangeRepository;
import com.prosmv.repositories.SizeRepository;
import com.prosmv.repositories.StyleRepository;
import com.prosmv.service.helper.StyleHelperService;
import com.prosmv.util.GenericUtils;

@Service
public class StyleService {

	@Autowired
	private StyleRepository styleRepository;
	@Autowired
	private FactoryRepository factoryRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private GridSizeRepository gridSizeRepository;
	@Autowired
	private RangeRepository rangeRepository;
	@Autowired
	private SizeRepository sizeRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(StyleHelperService.class);

	public Style createStyle(@Valid StyleForm styleForm) {
		Style style = null;
		if (!isStyleExists(styleForm)) {
			style = getStyle(styleForm);
			style = styleRepository.save(style);
		}
		return style;
	}

	private Style getStyle(StyleForm styleForm) {
		Style style = new Style();
		style.setCategory(categoryRepository.findById(styleForm.getCategoryId()));
		style.setDescription(styleForm.getDescription());
		style.setMerchantname(styleForm.getMerchantname());
		style.setSellPrice(styleForm.getSellingPrice());
		style.setStyleNotes(styleForm.getStyleNotes());
		style.setStyleName(styleForm.getName());
		style.setSeason(styleForm.getSeason());
		style.setSizeGrid(gridSizeRepository.findById(styleForm.getSizeGridId()));
		style.setRange(rangeRepository.findById(styleForm.getRangeId()));
		Brand brand = brandRepository.findById(styleForm.getBrandId());
		if (brand != null) {
			style.setBrand(brand);
		}
		CustomerSupplier customer = customerRepository.findById(styleForm.getCustomerId());
		if (customer != null) {
			style.setCustomerSupplier(customer);
		}
		Factory factory = factoryRepository.findById(styleForm.getFactoryId());
		style.setFactory(factory);
		style.setNeedleMin(styleForm.getNeedleMin());
		return style;
	}

//	private GridSize getGridSize(SizeGridForm sizeGridForm) {
//		GridSize gridSize = new GridSize();
//		gridSize.setGridValue(sizeGridForm.getGridValue());
//		Factory factory = factoryRepository.findById(sizeGridForm.getFactoryId());
//		gridSize.setFactory(factory);
//		return gridSize;
//	}

	private Size getSize(SizeForm sizeForm) {
		Size size = new Size();
		size.setSizeValue(sizeForm.getSizeValue());
		GridSize gridSize = gridSizeRepository.findById(sizeForm.getSizeGridId());
		size.setGridSize(gridSize);
		size.setActive('Y');
		size.setDeleted('N');
		if(sizeForm.getSizeDescription() != null) {
			size.setSizeDescription(sizeForm.getSizeDescription());
		}
		return size;
	}

//	private Range getRange(RangeForm rangeForm) {
//		Range range = new Range();
//		range.setName(rangeForm.getName());
//		Factory factory = factoryRepository.findById(rangeForm.getFactoryId());
//		range.setFactory(factory);
//		return range;
//	}

//	private Category getCategory(CategoryForm categoryForm) {
//		Category category = new Category();
//		category.setName(categoryForm.getName());
//		Factory factory = factoryRepository.findById(categoryForm.getFactoryId());
//		category.setFactory(factory);
//		return category;
//	}

	private boolean isStyleExists(@Valid StyleForm styleForm) {
		boolean styleExists = false;
		Factory factory = factoryRepository.findById(styleForm.getFactoryId());
		Style style = styleRepository.findByStyleNameAndFactory(styleForm.getName(), factory);
		if (style != null) {
			styleExists = true;
		}
		return styleExists;
	}

	public Style updateStyle(StyleForm styleForm, Long styleId) {
		Style style = null;
		Style oldStyle = styleRepository.findById(styleId);
		if (oldStyle != null) {
			style = getStyle(styleForm);
			style.setId(oldStyle.getId());
			style = styleRepository.save(style);
		}
		return style;
	}

	public Style deleteStyle(Long id) {
		Style style = null;
		style = styleRepository.findById(id);
		style.setDeleted(true);
		style = styleRepository.save(style);
		return style;
	}

	public List<StyleDTO> getAllStyles(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		List<Style> styles = styleRepository.findByFactory(factory);
		List<StyleDTO> styleList = new ArrayList<>();
		for (Style style : styles) {
			if (!style.isDeleted()) {
				StyleDTO styleDTO = new StyleDTO(style);
				styleList.add(styleDTO);
			}
		}
		return styleList;
	}

	public Style setStyleStatus(Long styleId, boolean active) {
		Style style = null;
		style = styleRepository.findById(styleId);
		style.setActive(active);
		style = styleRepository.save(style);
		return style;
	}

	public List<StyleDTO> getAutoCompleteStyle(String styleName, Long factoryId) {
		List<Style> styles = styleRepository.findByStyleNameIgnoreCaseContainingAndFactoryId(styleName, factoryId);
		List<StyleDTO> styleList = new ArrayList<>();
		for (Style style : styles) {
			styleList.add(new StyleDTO(style));
		}
		return styleList;
	}

	public List<StyleDTO> getUserStyles() {
		User user = GenericUtils.getLoggedInUser();
		List<StyleDTO> styleList = new ArrayList<>();
		List<Style> styles = new ArrayList<>();
		if (!user.getFactories().isEmpty()) {
			for (Factory factory : user.getFactories()) {
				List<Style> tempStyles = styleRepository.findByFactory(factory);
				if (!tempStyles.isEmpty()) {
					styles.addAll(tempStyles);
				}
			}
		}
		for (Style style : styles) {
			if (!style.isDeleted()) {
				StyleDTO styleDTO = new StyleDTO(style);
				styleList.add(styleDTO);
			}
		}
		return styleList;
	}

	public List<RangeDTO> getAutoCompleteRange(String rangeName, Long factoryId) {
		List<Range> ranges = rangeRepository.findByNameIgnoreCaseContainingAndFactoryId(rangeName, factoryId);
		List<RangeDTO> rangeList = new ArrayList<>();
		for (Range range : ranges) {
			rangeList.add(new RangeDTO(range));
		}
		return rangeList;
	}

	public List<CategoryDTO> getAutoCompleteCategory(String categoryName, Long factoryId) {
		List<Category> categories = categoryRepository.findByNameIgnoreCaseContainingAndFactoryId(categoryName,
				factoryId);
		List<CategoryDTO> categoryList = new ArrayList<>();
		for (Category category : categories) {
			categoryList.add(new CategoryDTO(category));
		}
		return categoryList;
	}

	public List<GridSizeDTO> getAutoCompleteGridSize(String gridSizeName, Long factoryId) {
		List<GridSize> gridSizes = gridSizeRepository.findByGridValueIgnoreCaseContainingAndFactoryId(gridSizeName,
				factoryId);
		List<GridSizeDTO> gridSizeList = new ArrayList<>();
		for (GridSize gridSize : gridSizes) {
			gridSizeList.add(new GridSizeDTO(gridSize));
		}
		return gridSizeList;
	}

	@Transactional(rollbackFor = Exception.class)
	public GridSize createSizeGrid(GridSize gridSize) {
		return gridSizeRepository.save(gridSize);
	}

//	private boolean isGridSizeExists(SizeGridForm sizeGridForm) {
//		boolean gridSizeExists = false;
//		Factory factory = factoryRepository.findById(sizeGridForm.getFactoryId());
//		GridSize gridSize = gridSizeRepository.findByGridValueAndFactory(sizeGridForm.getGridValue(), factory);
//		if (gridSize != null) {
//			gridSizeExists = true;
//		}
//		return gridSizeExists;
//	}

	private boolean isSizeExists(SizeForm sizeForm) {
		boolean sizeExists = false;
		GridSize gridSize = gridSizeRepository.findById(sizeForm.getSizeGridId());
		Size size = sizeRepository.findBySizeValueAndGridSize(sizeForm.getSizeValue(), gridSize);
		if (size != null) {
			sizeExists = true;
		}
		return sizeExists;
	}

//	private boolean isRangeExists(RangeForm rangeForm) {
//		boolean rangeExists = false;
//		Factory factory = factoryRepository.findById(rangeForm.getFactoryId());
//		Range range = rangeRepository.findByNameAndFactory(rangeForm.getName(), factory);
//		if (range != null) {
//			rangeExists = true;
//		}
//		return rangeExists;
//	}

//	private boolean isCategoryExists(@Valid CategoryForm categoryForm) {
//		boolean categoryExists = false;
//		Factory factory = factoryRepository.findById(categoryForm.getFactoryId());
//		Category category = categoryRepository.findByNameAndFactory(categoryForm.getName(), factory);
//		if (category != null) {
//			categoryExists = true;
//		}
//		return categoryExists;
//	}

	@Transactional(rollbackFor = Exception.class)
	public Size createSize(SizeForm sizeForm) {
		Size size = null;
		if (!isSizeExists(sizeForm)) {
			size = getSize(sizeForm);
			size = sizeRepository.save(size);
		}
		LOGGER.info("size: "+size);
		return size;
	}

	@Transactional(rollbackFor = Exception.class)
	public Range createRange(Range range) {
		return rangeRepository.save(range);
	}

	@Transactional(rollbackFor = Exception.class)
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * This service will be used to get all the {@link Range} based on
	 * {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link List} of {@link RangeDTO}
	 */
	public List<RangeDTO> getRangeByFactory(Long factoryId) {
		return rangeRepository.findByFactoryId(factoryId);
	}

	/**
	 * This service will be used to get all the {@link Category} based on
	 * {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link List} of {@link CategoryDTO}
	 */
	public List<CategoryDTO> getCategoryByFactory(Long factoryId) {
		return categoryRepository.findByFactoryId(factoryId);
	}

	/**
	 * This service will be used to get all {@link GridSize} based on
	 * {@link Factory}.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return {@link List} of {@link GridSizeDTO}
	 */
	public List<GridSizeDTO> getSizeGridByFactory(Long factoryId) {
		return gridSizeRepository.findByFactoryId(factoryId);
	}

	/**
	 * This service will be used to get all {@link Size} based on {@link GridSize}.
	 * 
	 * @param gridSizeId id of {@link GridSize}
	 * @return {@link List} of {@link SizeDTO}
	 */
	public List<SizeDTO> getSizeByGridSize(Long gridSizeId) {
		return sizeRepository.findByGridSizeId(gridSizeId);
	}

}
