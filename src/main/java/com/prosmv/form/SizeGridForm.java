package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.prosmv.annotations.factory.IsFactoryAlreadyExist;
import com.prosmv.annotations.groups.FactoryGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

public class SizeGridForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8491098441157622188L;
	@NotEmpty(message = ValidationMessageCode.GRID_VALUE_CANNOT_BE_NULL)
	@NotNull(message = ValidationMessageCode.GRID_VALUE_CANNOT_BE_NULL)
	private String gridValue;

	@NotNull(message = ValidationMessageCode.FACTORY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsFactoryAlreadyExist(groups = FactoryGroup.class)
	private Long factoryId;

	public String getGridValue() {
		return gridValue;
	}

	public void setGridValue(String gridValue) {
		this.gridValue = gridValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

}
