package com.gi.groupingideas.controller;

import com.gi.groupingideas.model.User;
import com.gi.groupingideas.repository.UserOpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserOpsRepository userOpsRepository;

    @GetMapping("/user/getAllUser")
    public String getAllUser(){
        return userOpsRepository.getUser();
    }

    @PostMapping("/user/saveUser")
    public String saveUser(@RequestBody User user){
        return userOpsRepository.saveUser(user);
    }

    @DeleteMapping("/user/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String id){
        return  userOpsRepository.deleteUser(id);
    }

    @PatchMapping("/user/updateUser/{id}")
    public String updateUser(@PathVariable("id") String id,@RequestBody User user){
        return userOpsRepository.updateUser(id,user);
    }

    @PutMapping("/user/modifyUser/{id}")
    public String modifyUser(@PathVariable("id") String id,@RequestBody User user){
        return userOpsRepository.modifyUser(id,user);
    }
}
