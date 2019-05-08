package com.prosmv.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.prosmv.domain.Factory;
import com.prosmv.domain.Machine;
import com.prosmv.domain.StitchClass;
import com.prosmv.domain.User;

public class MachineDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5854568857993323698L;

	private Long id;
	private String name;
	private int rpm;
	private int allowance;
	private String machineType;
	private String machineColor;
	private String stitchClassName;
	private Long stitchClassId;
	private Long factoryId;
	private String factoryName;

	public MachineDTO(Machine machine) {
		if (machine != null) {
			this.id = machine.getId();
			this.name = machine.getName();
			this.rpm = machine.getRpm();
			this.allowance = machine.getAllowance();
			this.machineType = machine.getMachineType();
			this.machineColor = machine.getMachineColor();
			if (machine.getStitchClass() != null) {
				StitchClass stitchClass = machine.getStitchClass();
				this.stitchClassName = stitchClass.getName();
				this.stitchClassId = stitchClass.getId();
			}
			if (machine.getFactory() != null) {
				Factory factory = machine.getFactory();
				this.factoryId = factory.getId();
				this.factoryName = factory.getName();
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getMachineColor() {
		return machineColor;
	}

	public void setMachineColor(String machineColor) {
		this.machineColor = machineColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStitchClassName() {
		return stitchClassName;
	}

	public void setStitchClassName(String stitchClassName) {
		this.stitchClassName = stitchClassName;
	}

	public Long getStitchClassId() {
		return stitchClassId;
	}

	public void setStitchClassId(Long stitchClassId) {
		this.stitchClassId = stitchClassId;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

}
