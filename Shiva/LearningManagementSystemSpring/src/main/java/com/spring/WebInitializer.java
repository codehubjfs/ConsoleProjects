package com.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
    protected Class<?>[] getRootConfigClasses() {
        // Specify root configuration classes
        return new Class[] { DispatcherConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	System.out.println("Helo this is SHiva");
        // Specify configuration classes for the DispatcherServlet application context
        return new Class[] { DispatcherConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Map the DispatcherServlet to "/"
        return new String[] { "/" };
    }

}
