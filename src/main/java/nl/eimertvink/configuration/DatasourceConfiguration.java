package nl.eimertvink.configuration;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() { return new DriverManagerDataSource(); }


    @Bean(name = "liquibaseDS")
    @LiquibaseDataSource
    @ConfigurationProperties(prefix="spring.liquibase.datasource")
    public DataSource liquibaseDataSource() { return new DriverManagerDataSource(); }

}
