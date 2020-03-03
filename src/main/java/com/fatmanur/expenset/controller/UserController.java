package com.fatmanur.expenset.controller;

import com.fatmanur.expenset.model.User;
import com.fatmanur.expenset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api-user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getuserlist")
    public List<User> getUserList() {
        System.out.println("backend controller");
        return userService.getUserList();
    }
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
