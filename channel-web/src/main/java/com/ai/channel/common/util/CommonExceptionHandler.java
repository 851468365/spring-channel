package com.ai.channel.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ai.channel.util.exception.CommonException;

public class CommonExceptionHandler implements HandlerExceptionResolver{
	private static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);  
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		Map<String, Object> model = new HashMap<String, Object>();  
		model.put("exception", exception);  
        if(exception instanceof CommonException) {  
        	CommonException commonException = (CommonException) exception;
        	logger.error("Catch Exception, errorCode: ", commonException.getErrorCode());
        	logger.error("Catch Exception, errorMsg: ", commonException.getMessage());
        	logger.error("Catch Exception, exception: ", commonException);
        	model.put("errorCode",commonException.getErrorCode());
    		model.put("errorMsg", commonException.getMessage());
    		model.put("exception", commonException);
            return new ModelAndView("/commonError", model);
        }else {
        	logger.error("Catch Exception: ", exception);
            return new ModelAndView("/error", model);
		}
	}

}
