package ma.hassan.etudiant.security;

import ma.hassan.etudiant.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(passwordEncoder.encode("1234"));

//        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("12345")).roles("user").and()
//                .withUser("admin1").password(passwordEncoder.encode("12345")).roles("admin","user");
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username as principal ,password as credentials,active from users where username=? ")
//                .authoritiesByUsernameQuery("select username principal ,role as user_roles from users_roles where username= ?")
//                .rolePrefix("ROLE_")
//                .passwordEncoder(passwordEncoder());

        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").defaultSuccessUrl("/user/index", true);
        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
        //http.authorizeHttpRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeHttpRequests().antMatchers("/admin/**").hasAuthority("admin");
        http.authorizeHttpRequests().antMatchers("/user/**").hasAuthority("user");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        //http.authorizeHttpRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");

    }

}
