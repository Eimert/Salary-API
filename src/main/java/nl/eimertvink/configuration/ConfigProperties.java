package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("classpath:application.properties")
@ConfigurationProperties(prefix = "database")
public class ConfigProperties {
    @Value("${spring.datasource.url}")
    private String databaseURL;

    public String getDatabaseURL() {
        return databaseURL;
    }

}
