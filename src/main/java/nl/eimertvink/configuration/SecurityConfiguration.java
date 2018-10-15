package nl.eimertvink.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john").password(new BCryptPasswordEncoder().encode("sonmez")).roles("ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "SELECT email,password,enabled FROM salaries WHERE email=?")
            .authoritiesByUsernameQuery(
                "SELECT s.email,ur.role FROM salaries s,user_roles ur WHERE s.id=ur.salariesid AND s.email=?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
// beautiful form-based auth; works
//        http
//            .csrf().disable()
//            .exceptionHandling()
//            .authenticationEntryPoint(restAuthenticationEntryPoint)
//            .and()
//            .authorizeRequests()
//            .antMatchers("/api/employee").authenticated()
//            .and()
//            .formLogin()
//            .successHandler(authenticationSuccessHandler)
//            .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//            .and()
//            .logout();

//        http.csrf().disable();
//        http
//                .exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .anonymous();

// previous config, all fine
        //        http
//                .authorizeRequests()
////                .anyRequest().authenticated()
//                .antMatchers("/api/employee").authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();


//        http
//                .httpBasic(); // Auth with HTTP Basic authentication
//        http
//                .exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/actuator/**").hasAuthority("ADMIN")
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/v2/api-docs",
//                        "/swagger-resources/**",
//                        "/swagger-ui.html**",
//                        "/webjars/**",
//                        "favicon.ico",
//                        "/api/**",
//                        "/v2/**"
//                ).permitAll()
//                .antMatchers("/login/**").permitAll()
//                .anyRequest().authenticated();

// basic: works fine
//        super.configure(http);
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//            .and()
//            .httpBasic(); // Auth with HTTP Basic authentication
//        http.csrf();


//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .antMatchers("/login*").anonymous()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login.html")
//                    .defaultSuccessUrl("/homepage.html")
//                    .failureUrl("/login.html?error=true")
//                    .and()
//                    .logout().logoutSuccessUrl("/login.html");


        // everyone can view all employees (read-only)
        // Members of HR can create, update, delete.
//        http
//            .httpBasic(); // Auth with HTTP Basic authentication
//        http
//            .authorizeRequests()
//            .antMatchers("/api/employee", "/login*").anonymous()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
////            .loginPage("/login.html")
////            .defaultSuccessUrl("/api/employee")
////            .failureUrl("/login.html?error=true")
//            .and()
//            .logout();
//
//        http.csrf().disable();

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
        http.csrf().disable();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }
}
