package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigProperties {
    @Value("${spring.datasource.url}")
    private String databaseURL;

    public String getDatabaseURL() {
        return databaseURL;
    }

}
