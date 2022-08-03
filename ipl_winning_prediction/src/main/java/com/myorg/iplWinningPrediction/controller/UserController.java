package com.myorg.iplWinningPrediction.controller;

import com.myorg.iplWinningPrediction.model.Login;
import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    //add user
    @PostMapping("/signup")
    public String addUser(@RequestBody User user){
        user.setPlayForToday(false);
        user.setWin(false);
        return this.userService.addUser(user);
    }

    //login user
    @PostMapping("/login")
    public User userLogin(@RequestBody Login login) {
        List<User> user = getAllUser();
        for (User u : user) {
            if (login.getEmail().equals(u.getEmail()) && login.getPassword().equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    //delete user
    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable String id){
        return this.userService.deleteUser(Integer.parseInt(id));
    }

    //get user by id
    @PostMapping("/get-user/{id}")
    public User getUserById(@PathVariable String id){
        return this.userService.getUserById(Integer.parseInt(id));

    }

    //get all user
    @PostMapping("/get-users")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    //update user
}
