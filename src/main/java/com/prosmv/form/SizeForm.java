package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

public class SizeForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7812877763366431147L;
//	@NotEmpty(message = ValidationMessageCode.GRID_VALUE_CANNOT_BE_NULL)
//	@NotNull(message = ValidationMessageCode.GRID_VALUE_CANNOT_BE_NULL)
	private String sizeValue;
	private String sizeDescription;
	@NotNull(message = ValidationMessageCode.GRID_SIZE_ID_CANNOT_BE_NULL,groups = NotNullGroup.class)
	private Long sizeGridId;
	public String getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(String sizeValue) {
		this.sizeValue = sizeValue;
	}
	public String getSizeDescription() {
		return sizeDescription;
	}
	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}
	public Long getSizeGridId() {
		return sizeGridId;
	}
	public void setSizeGridId(Long sizeGridId) {
		this.sizeGridId = sizeGridId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
