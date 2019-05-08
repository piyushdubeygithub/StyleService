package com.prosmv.service.helper;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Machine;
import com.prosmv.dto.MachineDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.MachineException;
import com.prosmv.form.MachineForm;
import com.prosmv.service.MachineService;
import com.prosmv.util.ResponseHandler;

/**
 * This Service class is used for machine service responses send to controller.
 * 
 * @author piyush
 *
 */
@Service
public class MachineHelperService {

	@Autowired
	 MachineService machineService;

	public ResponseDTO createMachine(@Valid MachineForm machineForm) {
		try {
			Machine machine = machineService.createMachine(machineForm);
			if(machine == null) {
				throw new MachineException(ServiceMessageCode.UNABLE_TO_CREATE_MACHINE);
			}
		} catch (Exception exception) {
			throw new MachineException(ServiceMessageCode.UNABLE_TO_CREATE_MACHINE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.MACHINE_CREATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO updateMachine( MachineForm machineForm, Long machineId) {
		try {
			Machine machine = machineService.updateMachine(machineForm, machineId);
			if(machine == null) {
				throw new MachineException(ServiceMessageCode.UNABLE_TO_CREATE_MACHINE);
			}
		} catch (Exception exception) {
			throw new MachineException(ServiceMessageCode.UNABLE_TO_CREATE_MACHINE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.MACHINE_UPDATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO deleteMachine(Long machineId) {
		try {
			machineService.deleteMachine(machineId);
		}catch(Exception ex) {
			throw new MachineException(ServiceMessageCode.UNABLE_TO_DELETE_MACHINE);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.MACHINE_DELETED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO getAllMachines(Long factoryId) {
		List<MachineDTO> machineDTOs = machineService.getAllMachines(factoryId);
		return ResponseHandler.generateServiceResponse(machineDTOs,
				ServiceMessageCode.MACHINE_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	public ResponseDTO getUserMachines() {
		List<MachineDTO> machineDTOs = machineService.getUserMachines();
		return ResponseHandler.generateServiceResponse(machineDTOs,
				ServiceMessageCode.MACHINE_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}
	
}
