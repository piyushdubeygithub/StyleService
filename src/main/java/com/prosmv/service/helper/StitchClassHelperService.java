package com.prosmv.service.helper;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.dto.StitchClassDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.StitchClassException;
import com.prosmv.form.StitchClassForm;
import com.prosmv.service.StitchClassService;
import com.prosmv.util.ResponseHandler;

/**
 * This Service class is used for comapny service responses send to controller.
 * 
 * @author piyush
 *
 */
@Service
public class StitchClassHelperService {
	private final static Logger LOGGER = LoggerFactory.getLogger(StitchClassHelperService.class);

	@Autowired
	private StitchClassService stitchClassService;

	public ResponseDTO saveStitchClass(@Validated StitchClassForm stitchClassForm) {
		try {
			stitchClassService.saveStitchClass(stitchClassForm);
		} catch (Exception exception) {
			throw new StitchClassException(ServiceMessageCode.UNABLE_TO_CREATE_STITCHCLASS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STITCHCLASS_CREATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO updateStitchClass(@Valid StitchClassForm stitchClassForm) {
		try {
			stitchClassService.updateStitchClass(stitchClassForm);
		} catch (Exception exception) {
			throw new StitchClassException(ServiceMessageCode.UNABLE_TO_CREATE_STITCHCLASS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STITCHCLASS_UPDATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO getAllStitchClass(Long id) {
		List<StitchClassDTO> stitchClassDTOs = stitchClassService.getStitchClasses(id);
		return ResponseHandler.generateServiceResponse(stitchClassDTOs,
				ServiceMessageCode.STITCHCLASS_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	public ResponseDTO deleteStitchClass(Long stitchClassId) {
		try {
			stitchClassService.deleteStitchClass(stitchClassId);
		} catch (Exception ex) {
			throw new StitchClassException(ServiceMessageCode.UNABLE_TO_DELETE_STITCHCLASS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.STITCHCLASS_DELETED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	public ResponseDTO getUserStitchClasses() {
		List<StitchClassDTO> stitchClassDTOs = stitchClassService.getUserStitchClasses();
		return ResponseHandler.generateServiceResponse(stitchClassDTOs,
				ServiceMessageCode.STITCHCLASS_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

}
