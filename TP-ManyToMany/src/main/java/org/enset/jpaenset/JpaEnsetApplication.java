package org.enset.jpaenset;

import org.enset.jpaenset.Service.UserService;
import org.enset.jpaenset.entities.Role;
import org.enset.jpaenset.entities.UserC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            UserC u= new UserC();
            u.setUsername("user3");
            u.setPassword("1234");
            userService.addNewUser(u);

            UserC u1= new UserC();
            u1.setUsername("admin2");
            u1.setPassword("1234");
            userService.addNewUser(u1);

//            Role role1 = new Role();
//            role1.setRolename("etudiant");
//            userService.AddNewRole(role1);

            Stream.of("etudiant","user","Admin").forEach(role->{
                Role role3 = new Role();
                role3.setRolename(role);
                userService.AddNewRole(role3);
            });
            userService.AddRoleToUserC("user3","etudiant");
            userService.AddRoleToUserC("admin2","user");

            userService.AddRoleToUserC("user3","Admin");
            userService.AddRoleToUserC("admin2","Admin");
            try{
                UserC user =userService.authenticate("user3","1234");
                System.out.println(user.getUserId());
                user.getRoles().forEach(System.out::println);
            }catch(Exception e){
                e.printStackTrace();
            }
        };
    }

}
