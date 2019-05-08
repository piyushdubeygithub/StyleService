package com.prosmv.dto;

import java.io.Serializable;
import com.prosmv.domain.StitchClass;

public class StitchClassDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1490274379113914626L;
	private Long id;
	private String name;
	private String description;
	private String machineType;
	private int needleCount;
	private int needleThread;
	private int looperThread;
	private double threadRatio;

	public StitchClassDTO(StitchClass stitchClass) {
     if(stitchClass != null) {
    	 this.id = stitchClass.getId();
    	 this.name = stitchClass.getName();
    	 this.description = stitchClass.getDescription();
    	 this.machineType = stitchClass.getMachineType();
    	 this.needleCount = stitchClass.getNeedleCount();
    	 this.needleThread = stitchClass.getNeedleCount();
    	 this.looperThread = stitchClass.getLooperThread();
    	 this.threadRatio = stitchClass.getThreadRatio();
     }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
