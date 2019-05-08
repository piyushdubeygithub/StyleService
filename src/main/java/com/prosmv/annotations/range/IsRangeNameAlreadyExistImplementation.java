package com.prosmv.annotations.range;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation class of {@link IsRangeNameAlreadyExist}
 * 
 * @author piyush
 *
 */
public class IsRangeNameAlreadyExistImplementation implements ConstraintValidator<IsRangeNameAlreadyExist, Object> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	private String className;

	@Override
	public void initialize(IsRangeNameAlreadyExist constraintAnnotation) {
		className = constraintAnnotation.className();
	}

	@Override
	public boolean isValid(Object rangeForm, ConstraintValidatorContext context) {
		try {
			Class<?> classOfObject = (Class<?>) Class.forName(className);
			Object objectOfClass = classOfObject.cast(rangeForm);
			Long factoryId = (Long) new PropertyDescriptor("factoryId", classOfObject).getReadMethod()
					.invoke(objectOfClass);
			String rangeName = (String) new PropertyDescriptor("name", classOfObject).getReadMethod()
					.invoke(objectOfClass);
			return !validationService.isRangeNameAlreadyExist(factoryId, rangeName);
		} catch (ClassNotFoundException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		} catch (InvocationTargetException e) {
			return false;
		} catch (IntrospectionException e) {
			return false;
		}
	}

}
