package com.sample.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("com.sample.dao.repository")
public class DatasourceConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("script/schema.sql")
				.addScript("script/data.sql").build();
	}

	 @Bean
	 public SqlSessionFactory sqlSessionFactory() throws Exception {
		 SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		 sqlSessionFactory.setDataSource(dataSource());
		 return (SqlSessionFactory) sqlSessionFactory.getObject();
	 }
	 
	 @Bean
	 public PlatformTransactionManager transactionManager() {
	     return new DataSourceTransactionManager(dataSource());
	 }
}
