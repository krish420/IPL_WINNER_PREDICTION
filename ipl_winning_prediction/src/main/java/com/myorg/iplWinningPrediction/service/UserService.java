package com.myorg.iplWinningPrediction.service;

import com.myorg.iplWinningPrediction.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    String addUser(User user);

    String deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUser();
}
