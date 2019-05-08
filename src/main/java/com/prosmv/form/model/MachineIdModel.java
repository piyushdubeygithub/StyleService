package com.prosmv.form.model;

import javax.validation.constraints.NotNull;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

public class MachineIdModel {

	@NotNull(message = ValidationMessageCode.MACHINE_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private Long machineId;


	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	/**
	 * @param factoryId
	 */
	public MachineIdModel(@NotNull(message = "machine.id.required") Long machineId) {
		super();
		this.machineId = machineId;
	}

	/**
	 * 
	 */
	public MachineIdModel() {
		super();
	}

}
