package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.factory.IsFactoryAlreadyExist;
import com.prosmv.annotations.factory.IsFactoryMappedWithUser;
import com.prosmv.annotations.groups.FactoryGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.RangeGroup;
import com.prosmv.annotations.groups.UserFactoryGroup;
import com.prosmv.annotations.range.IsRangeNameAlreadyExist;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@IsRangeNameAlreadyExist(className = "com.prosmv.form.RangeForm",groups = RangeGroup.class)
public class RangeForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5757903315108575530L;

	@NotNull(message = ValidationMessageCode.FACTORY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsFactoryAlreadyExist(groups = FactoryGroup.class)
//	@IsFactoryMappedWithUser(groups = UserFactoryGroup.class)
	private Long factoryId;

	@NotNull(message = ValidationMessageCode.RANGE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.RANGE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String name;

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
	 * 
	 */
	public RangeForm() {
		super();
	}

	/**
	 * @param factoryId
	 * @param name
	 */
	public RangeForm(@NotNull(message = "factory.id.required", groups = NotNullGroup.class) Long factoryId,
			@NotNull(message = "range.name.required", groups = NotNullGroup.class) @NotEmpty(message = "range.name.required", groups = NotNullGroup.class) String name) {
		super();
		this.factoryId = factoryId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "RangeForm [factoryId=" + factoryId + ", name=" + name + "]";
	}

}
