package com.otp.testing.exception;

public class OTPException extends RuntimeException{
	
	public OTPException(String message) {
		super(message);
	}
	
	public OTPException(String message, Throwable cause) {
		super(message, cause);
	}

}
