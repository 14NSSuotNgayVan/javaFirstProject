package com.java.java.controller;

import com.java.java.dto.request.UserCreationRequest;
import com.java.java.dto.request.UserUpdateRequest;
import com.java.java.entity.User;
import com.java.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
   }

   @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
   }
   @GetMapping("/{id}")
    User getUser(@PathVariable("id") String id){
        return userService.getUserById(id);
   }

   @PutMapping("/{id}")
    void updateUser(@PathVariable("id") String id, @RequestBody UserUpdateRequest request){
        userService.UpdateUser(id,request);
   }
}
