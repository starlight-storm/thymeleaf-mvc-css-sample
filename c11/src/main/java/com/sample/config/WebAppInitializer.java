package com.sample.config;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
//        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("classpath*:com/sample/config/transactionByFile.xml");
// 
//        ServletRegistration.Dynamic dispatcher = container
//          .addServlet("dispatcher", new DispatcherServlet(context));
// 
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
    }
}