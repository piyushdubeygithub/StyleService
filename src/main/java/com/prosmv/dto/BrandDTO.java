package com.prosmv.dto;

import java.io.Serializable;
import com.prosmv.domain.Brand;

public class BrandDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402855456603227787L;

	private Long id;
	private String name;
	private boolean isDeleted;
	
	public BrandDTO(Brand brand) {
		if(brand != null && !brand.isDeleted()) {
			this.id = brand.getId();
			this.name = brand.getName();
			this.isDeleted = brand.isDeleted();
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
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
