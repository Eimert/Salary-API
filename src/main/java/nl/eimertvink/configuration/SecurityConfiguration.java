package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "SELECT username,password,enabled FROM salaries WHERE username=?")
            .authoritiesByUsernameQuery(
                "SELECT s.username,ur.role FROM salaries s,user_roles ur WHERE s.id=ur.salariesid AND s.username=?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic(); // Auth with HTTP Basic authentication
        http
                .exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //.antMatchers("/actuator/**").permitAll()
                .antMatchers("/actuator/**").hasAuthority("ADMIN")
                .antMatchers(
                        HttpMethod.GET,
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**",
                        "favicon.ico"
                ).permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();

// basic: works fine
//        super.configure(http);
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//            .and()
//            .httpBasic(); // Auth with HTTP Basic authentication
//        http.csrf();

        // everyone can view
//        http
//             .authorizeRequests()
//             .antMatchers("/api/employee", "/login*").anonymous()
//              .and()
//                .authorizeRequests()
//                .antMatchers("/api/employee/**").hasAnyRole("ROLE_ADMIN")
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();

//                .loginPage("/login")
//                .defaultSuccessUrl("/api/employee")
//                .failureUrl("/login?error")
//                .and()
//                .logout().logoutSuccessUrl("/login");
            // managers can create, update, delete

        http.csrf().disable();

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
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
