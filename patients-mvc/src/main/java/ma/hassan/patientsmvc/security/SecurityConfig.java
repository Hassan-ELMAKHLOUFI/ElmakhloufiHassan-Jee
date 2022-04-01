package ma.hassan.patientsmvc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("{noop}user1").password("1234").roles("user").and()
                .withUser("admin1").password("1234").roles("admin","user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin();
       http.authorizeHttpRequests().anyRequest().authenticated();
    }
}
