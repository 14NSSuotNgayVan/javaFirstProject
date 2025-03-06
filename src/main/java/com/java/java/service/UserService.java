package com.java.java.service;

import com.java.java.dto.request.UserCreationRequest;
import com.java.java.dto.request.UserUpdateRequest;
import com.java.java.entity.User;
import com.java.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    };

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException(("user not found")));
    }

    public void UpdateUser(String id , UserUpdateRequest request){
        User user = getUserById(id);
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        userRepository.save(user);
    }
}
