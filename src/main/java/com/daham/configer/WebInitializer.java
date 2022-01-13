package com.daham.configer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
//		Class<?>[] configClasses  = {AppConfig.class};
//		return configClasses;
		
		return new Class<?>[] {AppConfig.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		// String[] mapping = { "/" };
		// getServletMappings(): This declares the servlet root URI.

		return new String[] { "/" };
	}

}
