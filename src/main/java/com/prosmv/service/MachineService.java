package com.prosmv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Machine;
import com.prosmv.domain.StitchClass;
import com.prosmv.domain.User;
import com.prosmv.dto.CustomerDTO;
import com.prosmv.dto.MachineDTO;
import com.prosmv.dto.MachineListDTO;
import com.prosmv.form.MachineForm;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.MachineRepository;
import com.prosmv.repositories.StitchClassRepository;
import com.prosmv.util.GenericUtils;

@Service
public class MachineService {

	@Autowired
	private MachineRepository machineRepository;
	@Autowired
	private FactoryRepository factoryRepository;
	@Autowired
	private StitchClassRepository stitchClassRepository;

	public Machine createMachine(@Valid MachineForm machineForm) {
		Machine machine = null;
		if (!isMachineExists(machineForm)) {
			machine = getMachine(machineForm);
			if (machine != null) {
				machineRepository.save(machine);
			}
		}
		return machine;
	}

	private Machine getMachine( MachineForm machineForm) {
		Factory factory = factoryRepository.findById(machineForm.getFactoryId());
		StitchClass stitchClass = stitchClassRepository.findById(machineForm.getStitchClassId());
		if (factory == null || stitchClass == null) {
			return null;
		}
		Machine machine = new Machine();
		machine.setName(machineForm.getMachineName());
		machine.setAllowance(machineForm.getAllowance());
		machine.setMachineColor(machineForm.getMachineColor());
		machine.setMachineType(machineForm.getMachineType());
		machine.setRpm(machineForm.getRpm());
		machine.setActive(true);
		machine.setStitchClass(stitchClass);
		machine.setFactory(factory);
		return machine;
	}

	private boolean isMachineExists(@Valid MachineForm machineForm) {
		boolean machineExists = false;
		Factory factory = factoryRepository.findById(machineForm.getFactoryId());
		Machine machine = machineRepository.findByNameAndFactory(machineForm.getMachineName(), factory);
		if (machine != null) {
			machineExists = true;
		}
		return machineExists;
	}

	public Machine updateMachine( MachineForm machineForm, Long machineId) {
		Machine machine = null;
		Machine oldMachine = machineRepository.findById(machineId);
		if (oldMachine != null) {
			machine = getMachine(machineForm);
			machine.setId(oldMachine.getId());
			if(machine != null) {
				machine = machineRepository.save(machine);
			}
		}
		return machine;
	}

	public Machine deleteMachine(Long id) {
		Machine machine = null;
		machine = machineRepository.findById(id);
		if (machine != null) {
			machine.setDeleted(true);
			machine = machineRepository.save(machine);
		}
		return machine;
	}

	public List<MachineDTO> getAllMachines(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		List<Machine> machines = machineRepository.findByFactory(factory);
		List<MachineDTO> machineList = new ArrayList<>();
		for (Machine machine : machines) {
			if (!machine.isDeleted()) {
				MachineDTO machineDTO = new MachineDTO(machine);
				machineList.add(machineDTO);
			}
		}
		return machineList;
	}

	public List<MachineDTO> getUserMachines() {
		User user = GenericUtils.getLoggedInUser();
		List<MachineDTO> machineList = new ArrayList<>();
		List<Machine> machines = new ArrayList<>();
		if (!user.getFactories().isEmpty()) {
			for (Factory factory : user.getFactories()) {
				List<Machine> tempMachines = machineRepository.findByFactory(factory);
				if (!tempMachines.isEmpty()) {
					machines.addAll(tempMachines);
				}
			}
		}
			for (Machine machine : machines) {
				if(!machine.isDeleted()) {
					MachineDTO machineDTO = new MachineDTO(machine);
					machineList.add(machineDTO);
				}
			}
		return machineList;
	}

}
