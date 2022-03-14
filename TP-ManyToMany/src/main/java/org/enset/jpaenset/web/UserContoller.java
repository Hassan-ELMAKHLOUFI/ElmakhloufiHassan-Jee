package org.enset.jpaenset.web;

import org.enset.jpaenset.Service.UserService;
import org.enset.jpaenset.entities.UserC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public UserC getUserByUserName(@PathVariable String username){
        return userService.findUserByUserName(username);
    }


}
