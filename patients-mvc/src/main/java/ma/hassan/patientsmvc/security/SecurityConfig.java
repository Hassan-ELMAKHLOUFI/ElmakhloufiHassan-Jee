package ma.hassan.patientsmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("12345")).roles("user").and()
                .withUser("admin1").password(passwordEncoder().encode("12345")).roles("admin","user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin();
//       http.authorizeHttpRequests().anyRequest().authenticated();

       http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("admin");
       http.authorizeHttpRequests().antMatchers("/user/**").hasRole("user");
       http.authorizeHttpRequests().anyRequest().authenticated();
       http.exceptionHandling().accessDeniedPage("/403");
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
