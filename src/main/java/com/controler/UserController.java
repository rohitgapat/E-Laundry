package com.controler;

import com.entity.User;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUesr();
    }
}
