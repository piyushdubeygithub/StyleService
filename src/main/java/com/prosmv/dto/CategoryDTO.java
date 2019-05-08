package com.prosmv.dto;

import com.prosmv.domain.Category;
import com.prosmv.domain.Factory;

public class CategoryDTO {
	
	private Long id;
	private String name;
	private Factory factory;
	
	public CategoryDTO(Category category) {
		if(category != null) {
			this.id = category.getId();
			this.name = category.getName();
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	/**
	 * @param id
	 * @param name
	 * @param factory
	 */
	public CategoryDTO(Long id, String name, Factory factory) {
		super();
		this.id = id;
		this.name = name;
		this.factory = factory;
	}
	
}
