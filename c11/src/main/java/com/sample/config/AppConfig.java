package com.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatasourceConfig.class, DozerBeanMappingConfiguration.class})
public class AppConfig {

}