package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "SELECT username,password,enabled FROM users WHERE username=?")
            .authoritiesByUsernameQuery(
                "SELECT u.username,ur.role FROM users u, user_roles ur WHERE u.id = ur.userid AND u.username=?")
            .passwordEncoder(new BCryptPasswordEncoder());
//
//        auth.inMemoryAuthentication()
//                .withUser("john").password("{noop}sonmez").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
            .and()
            .httpBasic(); // Auth with HTTP Basic authentication
        http.csrf();
//        http.authorizeRequests()
//            .antMatchers("/api/**").access("hasRole('ROLE_USER')")
//            .anyRequest().permitAll();
//          .and()
//            .formLogin().loginPage("/login").failureUrl("/login?error")
//            .usernameParameter("username").passwordParameter("password")
//          .and()
//            .logout().logoutSuccessUrl("/login?logout")
//          .and()
//            .exceptionHandling().accessDeniedPage("/403");
//          .and()
//            .csrf();
//        http.csrf().disable();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
