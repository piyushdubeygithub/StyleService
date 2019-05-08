package com.prosmv.form;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.domain.User;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StitchClassForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5980381817722135732L;
	private Long id;
	@NotEmpty(message="Please enter valid stichClass")
	@NotNull(message="Please enter valid stichClass")
	private String name;
	private String description;
	private String machineType;
	private Long factoryId;
	private int needleCount;
	private int needleThread;
	private int looperThread;
	private double threadRatio;
	private boolean isActive;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private User createdBy;
	private User updatedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public int getNeedleCount() {
		return needleCount;
	}
	public void setNeedleCount(int needleCount) {
		this.needleCount = needleCount;
	}
	public int getNeedleThread() {
		return needleThread;
	}
	public void setNeedleThread(int needleThread) {
		this.needleThread = needleThread;
	}
	public int getLooperThread() {
		return looperThread;
	}
	public void setLooperThread(int looperThread) {
		this.looperThread = looperThread;
	}
	public double getThreadRatio() {
		return threadRatio;
	}
	public void setThreadRatio(double threadRatio) {
		this.threadRatio = threadRatio;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	
}
