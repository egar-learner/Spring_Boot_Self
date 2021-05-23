package com.otp.testing.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class OTPExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleOTPExceptions(OTPException exception){
		
		// 1. Create a class that will hold values understandable to user
		//		which will have values set based on the values cause in exception
		
		OTPUserSendingException otpUserSendingException = new OTPUserSendingException(exception.getMessage(),
				exception,
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z")));
		
		// 2. Send back the response Entity
		return new ResponseEntity<>(otpUserSendingException, HttpStatus.BAD_REQUEST);
		
	}

}
