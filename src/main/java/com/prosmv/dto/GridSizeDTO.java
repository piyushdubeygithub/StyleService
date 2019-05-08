package com.prosmv.dto;

import java.io.Serializable;

import com.prosmv.domain.Factory;
import com.prosmv.domain.GridSize;

public class GridSizeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7635858962775201549L;
	private Long id;
	private String gridValue;
	private Factory factory;

	public GridSizeDTO(GridSize gridSize) {
		if (gridSize != null) {
			this.id = gridSize.getId();
			this.gridValue = gridSize.getGridValue();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGridValue() {
		return gridValue;
	}

	public void setGridValue(String gridValue) {
		this.gridValue = gridValue;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param id
	 * @param gridValue
	 * @param factory
	 */
	public GridSizeDTO(Long id, String gridValue, Factory factory) {
		super();
		this.id = id;
		this.gridValue = gridValue;
		this.factory = factory;
	}

}
