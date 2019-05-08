package com.prosmv.annotations.size;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsGridSizeExist}.
 * @author piyush
 *
 */
public class IsGridSizeExistImplementation implements ConstraintValidator<IsGridSizeExist, Long>{

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);
	
	@Override
	public boolean isValid(Long gridSizeId, ConstraintValidatorContext context) {
		return validationService.isGridSizeExist(gridSizeId);
	}

}
