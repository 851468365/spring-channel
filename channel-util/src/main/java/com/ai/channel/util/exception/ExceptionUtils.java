package com.ai.channel.util.exception;

/**
 * 
 * Description:产生异常消息
 * @author: zhouzulin
 *
 */
public abstract class ExceptionUtils {

	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			StringBuffer buf = new StringBuffer();
			if (message != null) {
				buf.append(message).append("; ");
			}
			buf.append("nested exception is ").append(cause);
			return buf.toString();
		} else
			return message;
	}
}
