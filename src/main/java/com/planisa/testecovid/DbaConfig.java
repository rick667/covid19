package com.planisa.testecovid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.sql.DataSource;

@Configuration
public class DbaConfig {
	@Value("jdbc:mysql://localhost:3306/covid19?createDatabaseIfNotExist=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
    private String url;
    @Value("planisa")
    private String username;

    @Value("859199711Ri@")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    @Bean
    public HttpClient httpClient() {
      return HttpClientBuilder.create().build();
    }

    
}