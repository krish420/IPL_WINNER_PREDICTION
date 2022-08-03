package com.myorg.iplWinningPrediction.service.serviceImpl;

import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.repository.UserRepository;
import com.myorg.iplWinningPrediction.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service @Data @AllArgsConstructor @NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found"+username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
    }

    @Override
    public String addUser(User user) {
        boolean emailAlreadyExists = userRepository.existsUserByEmail(user.getEmail());
        boolean mobileAlreadyExists = userRepository.existsUserByMobileNumber(user.getMobileNumber());
        if (emailAlreadyExists) {
            return "Email id already exists";
        }
        if (mobileAlreadyExists) {
            return "Mobile number already exists";
        }
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            System.out.println(user.getPassword()+" "+user.getName());
            return "User created successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "User creation failed. Try Again";
        }

    }

    @Override
    public String deleteUser(int id) {
        List<User> usersList = getAllUser();
        for (User x : usersList) {
            if (Objects.equals(x.getUserId(), id)) {
                this.userRepository.delete(x);
                return "deleted";
            }
        }
        return "failed";

    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }


}
