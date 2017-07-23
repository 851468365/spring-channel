package com.ai.channel.util.exception;

public class ErrorCodeConstant {
	
	
	
	/*
	 * web层errorCode
	 */
	public static final String WEB_DEFAULT_ERROR_CODE= "10001"; //接口返回了错误信息 errorCode
	public static final String WEB_PARAMETER_ERROR = "10002"; //入参校验错误
	
	
	/*
	 * service层errorCode
	 */
	public static final String SV_DEFAULT_ERROR_CODE= "20001"; //接口返回了错误信息 errorCode
	public static final String SV_PARAMETER_ERROR = "20002"; //入参校验错误
	public static final String SV_ILLEGAL_OPERATION = "20003"; //非法操作
	public static final String SV_INTERFACE_ERROR = "20004"; //接口调用失败
	
	/*
	 * 与接口相关的errorCode
	 */
	public static final String INTF_DEFAULT_ERROR_CODE= "30001"; //接口返回了错误信息 errorCode
	public static final String INTF_PARAMETER_ERROR = "30002"; //入参校验错误


}
