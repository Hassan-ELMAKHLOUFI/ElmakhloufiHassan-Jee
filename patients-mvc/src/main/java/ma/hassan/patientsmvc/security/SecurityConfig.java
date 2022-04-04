package ma.hassan.patientsmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(passwordEncoder().encode("12345"));

        //auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("12345")).roles("user").and()
        //        .withUser("admin1").password(passwordEncoder().encode("12345")).roles("admin","user");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal ,password as credentials,active from users where username=? ")
                .authoritiesByUsernameQuery("select username principal ,role as user_roles from users_roles where username= ?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder());

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
