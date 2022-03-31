package com.vnaazleen.instrumentDelight.controller;

import com.vnaazleen.instrumentDelight.model.User;
import com.vnaazleen.instrumentDelight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class SignupController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/saveUser"})
    @CrossOrigin(origins = "http://localhost:4200/")
    public User saveUser(@RequestBody User user)throws Exception {
        String tempUsername=user.getUsername();
        if(tempUsername !=null && !" ".equals(tempUsername)){
            User userobj=userService.fetchUserByUsername(tempUsername);
            if(userobj !=null) {
                throw new Exception("User with this "+tempUsername+" is Already Exist");
            }
        }
        User userObj=null;
        userObj=userService.saveUser(user);
        return userObj;
    }

    @GetMapping({"/forAdmin"})
    @CrossOrigin(origins = "http://localhost:4200/")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @CrossOrigin(origins = "http://localhost:4200/")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
