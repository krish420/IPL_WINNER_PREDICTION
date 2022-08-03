package com.myorg.iplWinningPrediction.repository;

import com.myorg.iplWinningPrediction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsUserByEmail(String email);
    boolean existsUserByMobileNumber(String mobileNumber);
    User findByEmail(String username);
    User findById(int id);
}
