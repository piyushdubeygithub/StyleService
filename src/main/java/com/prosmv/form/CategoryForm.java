package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.category.IsCategoryNameAlreadyExist;
import com.prosmv.annotations.factory.IsFactoryAlreadyExist;
import com.prosmv.annotations.factory.IsFactoryMappedWithUser;
import com.prosmv.annotations.groups.CategoryGroup;
import com.prosmv.annotations.groups.FactoryGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.UserFactoryGroup;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@IsCategoryNameAlreadyExist(className = "com.prosmv.form.CategoryForm", groups = CategoryGroup.class)
public class CategoryForm implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1505076902629745304L;

	@NotNull(message = ValidationMessageCode.RANGE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.RANGE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String name;

	@NotNull(message = ValidationMessageCode.FACTORY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsFactoryAlreadyExist(groups = FactoryGroup.class)
//	@IsFactoryMappedWithUser(groups = UserFactoryGroup.class)
	private Long factoryId;

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
	 * 
	 */
	public CategoryForm() {
		super();
	}

	/**
	 * @param name
	 * @param factoryId
	 */
	public CategoryForm(
			@NotNull(message = "range.name.required", groups = NotNullGroup.class) @NotEmpty(message = "range.name.required", groups = NotNullGroup.class) String name,
			@NotNull(message = "factory.id.required", groups = NotNullGroup.class) Long factoryId) {
		super();
		this.name = name;
		this.factoryId = factoryId;
	}

	@Override
	public String toString() {
		return "CategoryForm [name=" + name + ", factoryId=" + factoryId + "]";
	}

}
