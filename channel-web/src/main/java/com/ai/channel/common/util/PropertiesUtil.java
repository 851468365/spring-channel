package com.ai.channel.common.util;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 获取系统配置参数的工具类
 *
 */
public class PropertiesUtil {
	
	private static ReloadableResourceBundleMessageSource resourceConfigurer = (ReloadableResourceBundleMessageSource) SpringContextUtils.getBeanById("resourceConfigurer");
	
	public static String getResourceString(String key) {
		return resourceConfigurer.getMessage(key, null, new Locale(""));
	}

}
