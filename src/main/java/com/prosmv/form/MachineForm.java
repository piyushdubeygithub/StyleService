package com.prosmv.form;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.constants.message.ValidationMessageCode;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MachineForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2386170580868489525L;

	@NotNull(message=ValidationMessageCode.ENTER_VALID_NAME)
	@NotEmpty(message=ValidationMessageCode.ENTER_VALID_NAME)
	private String machineName;
	private int rpm;
	private int allowance;
	private String machineType;
	private String machineColor;
	@NotNull(message=ValidationMessageCode.FACTORY_ID_CANNOT_BE_NULL)
	private Long factoryId;
	@NotNull(message=ValidationMessageCode.STITCHCLASS_ID_CANNOT_BE_NULL)
	private Long stitchClassId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
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
	public Long getStitchClassId() {
		return stitchClassId;
	}
	public void setStitchClassId(Long stitchClassId) {
		this.stitchClassId = stitchClassId;
	}
	
}
