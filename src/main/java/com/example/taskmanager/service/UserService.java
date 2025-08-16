package com.example.taskmanager.service;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User getUserByName(String name){
       Optional<User> data=userRepo.findByUsername(name);
       if (data.isPresent()){
           User user=data.get();
           return user;
       }
       else {
           return null;
       }
    }
}
