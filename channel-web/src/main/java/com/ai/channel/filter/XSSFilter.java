package com.ai.channel.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet Filter implementation class XSSFilter
 */
public class XSSFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(XSSFilter.class);

	private String []illegalString = {"<",">","&#","\"","\'", "\\", "\r", "\n"};
	
    public XSSFilter() {
        logger.debug("防范xss攻击过滤器被创建");
    }

	public void destroy() {
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		arg0.setCharacterEncoding("UTF-8");
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();
		Enumeration<String> paramNames = request.getParameterNames();
		boolean containsIllegal = false;
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String [] paramValues = request.getParameterValues(paramName);
			if(paramValues != null) {
				for(String value : paramValues) {
					for(int i = 0; i < illegalString.length; i++) {
						if(value.contains(illegalString[i])) {
							containsIllegal = true;
							break;
						}
					}
				}
			}
		}
		if(containsIllegal) {			
			request.getSession().setAttribute("ERRORMSG", "请求中包含非法信息");
			request.getRequestDispatcher("/template/error.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
