package com.prosmv.form.model;

import javax.validation.constraints.NotNull;

public class StyleIdModel {

	private Long styleId;

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}
	
	/**
	 * @param factoryId
	 */
	public StyleIdModel(@NotNull(message = "style.id.required") Long styleId) {
		super();
		this.styleId = styleId;
	}

	/**
	 * 
	 */
	public StyleIdModel() {
		super();
	}
}
