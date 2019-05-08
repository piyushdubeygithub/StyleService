package com.prosmv.form.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.SizeGroup;
import com.prosmv.annotations.size.IsGridSizeExist;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GridSizeIdModel {

	@NotNull(message = ValidationMessageCode.GRID_SIZE_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsGridSizeExist(groups = SizeGroup.class)
	private Long gridSizeId;

	/**
	 * @return the gridSizeId
	 */
	public Long getGridSizeId() {
		return gridSizeId;
	}

	/**
	 * @param gridSizeId the gridSizeId to set
	 */
	public void setGridSizeId(Long gridSizeId) {
		this.gridSizeId = gridSizeId;
	}

	/**
	 * 
	 */
	public GridSizeIdModel() {
		super();
	}

	/**
	 * @param gridSizeId
	 */
	public GridSizeIdModel(@NotNull(message = "grid.size.id.required", groups = NotNullGroup.class) Long gridSizeId) {
		super();
		this.gridSizeId = gridSizeId;
	}

}
