package com.app.propertytaxapplication.controller.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.propertytaxapplication.controller.PropertyTaxController;
import com.app.propertytaxapplication.dto.ErrorDto;
import com.app.propertytaxapplication.exception.PropertyTaxApplicationException;

@RestControllerAdvice
public class PropertyTaxExceptionHandler {

	@Autowired
	MessageSource messageSource;

	final static Logger logger = LogManager.getLogger(PropertyTaxController.class.getName());

	@ExceptionHandler(PropertyTaxApplicationException.class)
	public ResponseEntity<?> errorHandler(Exception e) {
		logger.fatal(e.getMessage());
		return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage(), e.getCause()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		String errorMessaage = "";
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorMessaage += error.getDefaultMessage() + ", ";
		}

		logger.fatal(ex.getMessage());
		return new ResponseEntity<ErrorDto>(new ErrorDto(errorMessaage, ex.getCause()), HttpStatus.BAD_REQUEST);

	}

}
