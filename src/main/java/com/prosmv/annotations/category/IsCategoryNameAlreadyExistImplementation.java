package com.prosmv.annotations.category;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsCategoryNameAlreadyExist}
 * @author piyush
 *
 */
public class IsCategoryNameAlreadyExistImplementation implements ConstraintValidator<IsCategoryNameAlreadyExist, Object>{

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	private String className;
	
	@Override
	public void initialize(IsCategoryNameAlreadyExist constraintAnnotation) {
		className = constraintAnnotation.className();
	}

	@Override
	public boolean isValid(Object categoryForm, ConstraintValidatorContext context) {
		try {
			Class<?> classOfObject = (Class<?>) Class.forName(className);
			Object objectOfClass = classOfObject.cast(categoryForm);
			Long factoryId = (Long) new PropertyDescriptor("factoryId", classOfObject).getReadMethod()
					.invoke(objectOfClass);
			String categoryName = (String) new PropertyDescriptor("name", classOfObject).getReadMethod()
					.invoke(objectOfClass);
			return !validationService.isCategoryNameAlreadyExist(factoryId, categoryName);
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
