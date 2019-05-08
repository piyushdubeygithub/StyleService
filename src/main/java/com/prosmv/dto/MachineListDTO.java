package com.prosmv.dto;

import java.io.Serializable;
import java.util.List;

import com.prosmv.domain.Machine;

public class MachineListDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2633198641731658229L;
	private List<MachineDTO> machines;

	public MachineListDTO() {

	}

	public MachineListDTO(List<MachineDTO> machines) {
		this.machines = machines;
	}

	public List<MachineDTO> getMachineDTOs() {
		return machines;
	}

	public void setMachineDTOs(List<MachineDTO> machines) {
		this.machines = machines;
	}

}
