package utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:dbConfig/dbCredentials.properties")
@ComponentScan(basePackages = {"storage.impl"})
public class DatabaseConfig {

	 @Value("${jdbc.driver}") String driverClassName;
	 @Value("${jdbc.url}") String url;
	 @Value("${jdbc.username}") String username;
	 @Value("${jdbc.password}") String password;
	 
	@Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost/inventoryObjects");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        
        return ds;
    }
	
}
