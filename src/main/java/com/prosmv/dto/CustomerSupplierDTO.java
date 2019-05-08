package com.prosmv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prosmv.domain.CustomerSupplier;

@JsonInclude(value = Include.NON_NULL)
public class CustomerSupplierDTO {

	private Long id;

	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	public CustomerSupplierDTO() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public CustomerSupplierDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CustomerSupplierDTO(CustomerSupplier customerSupplier) {
		if (customerSupplier != null) {
			this.id = customerSupplier.getId();
			this.name = customerSupplier.getName();
		}
	}

}
