package com.ai.channel.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonException extends BusinessBaseNestedCheckedException implements ErrorCode {
	private static final long serialVersionUID = -7061967469169619058L;

	private static Logger logger = LoggerFactory.getLogger(CommonException.class);  

	private String errorCode;

	private String errorMessage;

	public CommonException(String message) {
		super(message);
	}

	public CommonException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public CommonException(String errorCode, String message, Throwable ex) {
		super(message, ex);
		this.errorCode = errorCode;
		errorMessage = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return getMessage();
	}
	
	public void showDetail() {
		logger.error("code: " + errorCode + " , message: " + getMessage());
	}
}
