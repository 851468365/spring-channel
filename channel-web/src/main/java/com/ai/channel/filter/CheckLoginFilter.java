package com.ai.channel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckLoginFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(CheckLoginFilter.class);

	private String [] legalString =null;
	
	public CheckLoginFilter(){
		logger.debug("检查是否登录过滤器被创建");
	}

	@Override
	public void init(FilterConfig congiConfig) throws ServletException {
		//获取排除列表字符串，并对字符串进行切割
		String exclude = congiConfig.getInitParameter("exclude");
		legalString = exclude.split(",");
	}	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		arg0.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) response;
		logger.debug("检查是否登录......");
		String url = req.getRequestURI();
		HttpSession session = req.getSession(false);
		boolean containsIllegal = false;	
		
		if (session != null) {
			logger.info("session:" + session.toString());
			Object sysUser = session.getAttribute("sysUser");
			if (sysUser != null) {
				logger.info("sysUser:" + sysUser.toString());
			}
		}
		
		if(session == null || session.getAttribute("sysUser") == null){
			containsIllegal = true;
			for(int i = 0; i < legalString.length; i++) {
				if(url.contains(legalString[i])) {
						containsIllegal = false;
						break;				
				}
			}
		}
				
		if(containsIllegal) {			
			String path =  req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
			resp.setHeader("Cache-Control", "no-store");  
            resp.setDateHeader("Expires", 0);  
            resp.setHeader("Prama", "no-cache");
			resp.sendRedirect(path+"template/login.jsp");
			return;
		}
		chain.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		
	}

}
