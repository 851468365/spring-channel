package com.ai.channel.util.exception;

import java.io.PrintStream;
import java.io.PrintWriter;


public abstract class BusinessBaseNestedCheckedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4457082460343986145L;
	private Throwable rootCause;

	public BusinessBaseNestedCheckedException(String message) {
		super(message);

	}

	public BusinessBaseNestedCheckedException(String message, Throwable ex) {
		super(message, ex);
		rootCause = ex;
	}

	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	@Override
	public String getMessage() {
		return ExceptionUtils.buildMessage(super.getMessage(), rootCause);
	}

	public String getDetailMessage(){
		return super.getMessage();
	}
	@Override
	public void printStackTrace(PrintStream ps) {
		if (rootCause == null) {
			super.printStackTrace(ps);
		} else {
			ps.println(this);
			rootCause.printStackTrace(ps);
		}
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		if (rootCause == null) {
			super.printStackTrace(pw);
		} else {
			pw.println(this);
			rootCause.printStackTrace(pw);
		}
	}
}
