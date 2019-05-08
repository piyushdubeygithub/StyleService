package com.prosmv.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.StyleException;
import com.prosmv.util.ResponseHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(ArithmeticException.class)
//	public final ResponseEntity<Object> arithmeticExceptions(Exception ex, HttpServletRequest request) {
//		return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, true, Constant.ERROR, ex.getLocalizedMessage());
//	}
//
//	@ExceptionHandler(NullPointerException.class)
//	public final ResponseEntity<Object> nullPointerExceptions(Exception ex, HttpServletRequest request) {
//		return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, true, Constant.ERROR, ex.getLocalizedMessage());
//	}
//
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, HttpServletRequest request) {
//		return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, true, Constant.ERROR, ex.getLocalizedMessage());
//	}

	@ExceptionHandler(StyleException.class)
	public final ResponseEntity<ResponseDTO> handleStyleException(Exception exception) {
		return ResponseHandler.generateExceptionResponse(exception);
	}

}
