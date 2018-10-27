package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

// Dan Bunker spring data rest getting started
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // enable spring method level authorization
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("john").password("sonmez").roles("ADMIN");

//        DB auth:
//        auth.jdbcAuthentication().dataSource(dataSource)
//            .usersByUsernameQuery(
//                "SELECT email,password,enabled FROM salaries WHERE email=?")
//            .authoritiesByUsernameQuery(
//                "SELECT s.email,ur.role FROM salaries s,user_roles ur WHERE s.id=ur.salariesid AND s.email=?")
//            .passwordEncoder(new BCryptPasswordEncoder());

        // bCrypt
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Configuration
//    @Order(1)
//    static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//    }
//
//    @Configuration
//    @Order(2)
//    static class FormLoginSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            //
//        }
//    }

    // antMatcher ref: https://stackoverflow.com/questions/35890540/when-to-use-spring-securitys-antmatcher
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // form auth, or headless using curl. Reference: https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
        super.configure(http);
        http.csrf().disable();

        /* Default: no auth.
         * All requests to resources under /api should trigger basic auth dialog (or be done with Basic auth credentials provided in header)
         */

        http
            .antMatcher("/api/**")
//            .exceptionHandling()
//            .authenticationEntryPoint(new RestAuthenticationEntryPoint())
//            .and()
            .authorizeRequests()
//            .anyRequest().authenticated() //enabled: /api/employees There was an unexpected error (type=Unauthorized, status=401). // disabled: /login not found
            .anyRequest().hasRole("ADMIN")
            .and()
            .httpBasic();
//
//            .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//
//            .successHandler(new MySavedRequestAwareAuthenticationSuccessHandler())
//            .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//            .and()
//            .logout().permitAll();
    }
}
