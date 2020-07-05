package it.danieltrosko.lsauto.security;

import it.danieltrosko.lsauto.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, enabled FROM user WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, authority FROM authorities WHERE email=?")
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/car/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/pdf/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/repair/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/photo/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .cors().disable();
//                .cors().configurationSource(request -> new CorsConfiguration().a());
//                .authorizeRequests()
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/user/hello").authenticated()
//                .antMatchers("/api/car/**").authenticated()
//                .antMatchers("/api/repair/**").authenticated()
//                .and()
//                .sessionManagement();
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
