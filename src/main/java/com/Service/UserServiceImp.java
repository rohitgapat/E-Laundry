package com.Service;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String addNewUser(User user) {
        userRepo.save(user);
        return "User added successfully";
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUesr() {
        return userRepo.findAll();
    }
}
