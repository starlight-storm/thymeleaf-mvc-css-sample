package com.sample.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sample.pl.controller","com.sample.bl.service","com.sample.dao.repository", "com.sample.util"})
@Import(ThymeleafConfig.class)
@ImportResource("classpath:com/sample/config/transactionByFile.xml")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/i18n/messages");
        return messageSource;
    }
}
