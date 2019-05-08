package com.prosmv.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosmv.domain.Factory;
import com.prosmv.domain.Machine;
import com.prosmv.domain.StitchClass;
import com.prosmv.domain.User;
import com.prosmv.dto.MachineDTO;
import com.prosmv.dto.StitchClassDTO;
import com.prosmv.dto.StitchClassListDTO;
import com.prosmv.form.StitchClassForm;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.StitchClassRepository;
import com.prosmv.util.GenericUtils;

@Service
public class StitchClassService {

	@Autowired
	private StitchClassRepository stitchClassRepository;
	@Autowired
	private FactoryRepository factoryRepository;

	public StitchClass saveStitchClass(StitchClassForm stitchClassForm) {
		StitchClass stitchClass = null;
		if (!isStitchClassExists(stitchClassForm)) {
			stitchClass = getStitchClass(stitchClassForm);
			stitchClassRepository.save(stitchClass);
		}
		return stitchClass;
	}

	public StitchClass getStitchClass(StitchClassForm stitchClassForm) {
		StitchClass stitchClass = new StitchClass();
		stitchClass.setName(stitchClassForm.getName());
		if (stitchClassForm.getDescription() != null) {
			stitchClass.setDescription(stitchClassForm.getDescription());
		}
		if (stitchClassForm.getFactoryId() != null) {
			Factory factory = factoryRepository.findById(stitchClassForm.getFactoryId());
			stitchClass.setFactory(factory);
		}
		stitchClass.setLooperThread(stitchClassForm.getLooperThread());
		stitchClass.setThreadRatio(stitchClassForm.getThreadRatio());
		if (stitchClassForm.getMachineType() != null) {
			stitchClass.setMachineType(stitchClassForm.getMachineType());
		}
		stitchClass.setNeedleCount(stitchClassForm.getNeedleCount());
		stitchClass.setNeedleThread(stitchClassForm.getNeedleThread());
		return stitchClass;
	}

	private boolean isStitchClassExists(StitchClassForm stitchClassForm) {
		boolean stitchClassExists = false;
		Factory factory = factoryRepository.findById(stitchClassForm.getFactoryId());
		StitchClass stitchClass = stitchClassRepository.findByNameAndFactory(stitchClassForm.getName(), factory);
		if (stitchClass != null) {
			stitchClassExists = true;
		}
		return stitchClassExists;
	}

	public StitchClass updateStitchClass(@Valid StitchClassForm stitchClassForm) {
		StitchClass stitchClass = null;
		StitchClass oldStitchClass = stitchClassRepository.findById(stitchClassForm.getId());
		if (oldStitchClass != null) {
			stitchClass = getStitchClass(stitchClassForm);
			stitchClass.setId(oldStitchClass.getId());
			stitchClass = stitchClassRepository.save(stitchClass);
		}
		return stitchClass;
	}

	public List<StitchClassDTO> getStitchClasses(Long id) {
		Factory factory = factoryRepository.findById(id);
		List<StitchClass> stitchClasses = stitchClassRepository.findByFactory(factory);
		List<StitchClassDTO> stitchClassList = new ArrayList<>();
		for (StitchClass stitchClass : stitchClasses) {
			if (!stitchClass.isDeleted()) {
				stitchClassList.add(new StitchClassDTO(stitchClass));
			}
		}
		return stitchClassList;
	}

	public StitchClass deleteStitchClass(Long id) {
		StitchClass stitchClass = stitchClassRepository.findById(id);
		stitchClass.setDeleted(true);
		stitchClass = stitchClassRepository.save(stitchClass);
		return stitchClass;
	}

	public List<StitchClassDTO> getUserStitchClasses() {
		User user = GenericUtils.getLoggedInUser();
		List<StitchClassDTO> stitchClassList = new ArrayList<>();
		List<StitchClass> stitchClasses = new ArrayList<>();
		if (!user.getFactories().isEmpty()) {
			for (Factory factory : user.getFactories()) {
				List<StitchClass> tempstitchClasses = stitchClassRepository.findByFactory(factory);
				if (!tempstitchClasses.isEmpty()) {
					stitchClasses.addAll(tempstitchClasses);
				}
			}
		}
		for (StitchClass stitchClass : stitchClasses) {
			if (!stitchClass.isDeleted()) {
				stitchClassList.add(new StitchClassDTO(stitchClass));
			}
		}
		return stitchClassList;
	}

}
