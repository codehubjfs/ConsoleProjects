package com.hallbookingmanagement;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Specify root configuration classes
        return new Class[] { DispatherServlet.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	System.out.println("I'm in intializer");
        // Specify configuration classes for the DispatcherServlet application context
        return new Class[] { DispatherServlet.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Map the DispatcherServlet to "/"
        return new String[] { "/" };
    }
}
