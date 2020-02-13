package it.danieltrosko.lsauto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


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
                .and()
                .formLogin()
                .usernameParameter("email")
                .and()
                .csrf().disable();
    }
}
