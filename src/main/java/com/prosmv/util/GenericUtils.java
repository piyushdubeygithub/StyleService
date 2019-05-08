package com.prosmv.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.prosmv.domain.User;

/**
 * This class is utility class used for serveral purpose.
 * @author piyush
 *
 */
public class GenericUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericUtils.class);
	
	/**
	 *	This method is used to get logged in user.
	 */
	public static User getLoggedInUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
}
