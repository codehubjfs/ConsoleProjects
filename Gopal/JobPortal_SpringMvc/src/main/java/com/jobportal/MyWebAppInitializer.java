package com.jobportal;



//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.jobportal")
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
     * Specifies the root configuration classes for the application context.
     * @return Array of root configuration classes.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	 // Returning the configuration class for the application context
        return new Class[] { DispatherServlet.class };
    }
    /**
     * Specifies configuration classes for the DispatcherServlet application context.
     * @return Array of servlet configuration classes, null if none.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Specify configuration classes for the DispatcherServlet application context
        return null;
    }
    /**
     * Specifies the servlet mapping for the DispatcherServlet.
     * @return Array of servlet mapping URLs.
     */
    @Override
    protected String[] getServletMappings() {
        // Map the DispatcherServlet to "/"
        return new String[] { "/" };
    }
}
