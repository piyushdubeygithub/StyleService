package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.prosmv.constants.message.ValidationMessageCode;
import com.prosmv.enums.Seasons;

public class StyleForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 69505992101071641L;
	@NotEmpty(message = ValidationMessageCode.NAME_CANNOT_BE_NULL)
	@NotNull(message = ValidationMessageCode.NAME_CANNOT_BE_NULL)
	private String name;
	private String description;
	private Seasons season;
	private Long sizeGridId;
	private Long rangeId;
	private Long customerId;
	private Long factoryId;
	private Long brandId;
	private Long categoryId;
	private int sellingPrice;
	private String styleNotes;
	private String merchantname;
	private String needleMin;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the season
	 */
	public Seasons getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(Seasons season) {
		this.season = season;
	}

	/**
	 * @return the sizeGridId
	 */
	public Long getSizeGridId() {
		return sizeGridId;
	}

	/**
	 * @param sizeGridId the sizeGridId to set
	 */
	public void setSizeGridId(Long sizeGridId) {
		this.sizeGridId = sizeGridId;
	}

	/**
	 * @return the rangeId
	 */
	public Long getRangeId() {
		return rangeId;
	}

	/**
	 * @param rangeId the rangeId to set
	 */
	public void setRangeId(Long rangeId) {
		this.rangeId = rangeId;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the factoryId
	 */
	public Long getFactoryId() {
		return factoryId;
	}

	/**
	 * @param factoryId the factoryId to set
	 */
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the sellingPrice
	 */
	public int getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * @return the styleNotes
	 */
	public String getStyleNotes() {
		return styleNotes;
	}

	/**
	 * @param styleNotes the styleNotes to set
	 */
	public void setStyleNotes(String styleNotes) {
		this.styleNotes = styleNotes;
	}

	/**
	 * @return the merchantname
	 */
	public String getMerchantname() {
		return merchantname;
	}

	/**
	 * @param merchantname the merchantname to set
	 */
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	/**
	 * @return the needleMin
	 */
	public String getNeedleMin() {
		return needleMin;
	}

	/**
	 * @param needleMin the needleMin to set
	 */
	public void setNeedleMin(String needleMin) {
		this.needleMin = needleMin;
	}

	/**
	 * 
	 */
	public StyleForm() {
		super();
	}

	/**
	 * @param name
	 * @param description
	 * @param season
	 * @param sizeGridId
	 * @param rangeId
	 * @param customerId
	 * @param factoryId
	 * @param brandId
	 * @param categoryId
	 * @param sellingPrice
	 * @param styleNotes
	 * @param merchantname
	 * @param needleMin
	 */
	public StyleForm(@NotEmpty(message = "name.required") @NotNull(message = "name.required") String name,
			String description, Seasons season, Long sizeGridId, Long rangeId, Long customerId, Long factoryId,
			Long brandId, Long categoryId, int sellingPrice, String styleNotes, String merchantname, String needleMin) {
		super();
		this.name = name;
		this.description = description;
		this.season = season;
		this.sizeGridId = sizeGridId;
		this.rangeId = rangeId;
		this.customerId = customerId;
		this.factoryId = factoryId;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.sellingPrice = sellingPrice;
		this.styleNotes = styleNotes;
		this.merchantname = merchantname;
		this.needleMin = needleMin;
	}

}
