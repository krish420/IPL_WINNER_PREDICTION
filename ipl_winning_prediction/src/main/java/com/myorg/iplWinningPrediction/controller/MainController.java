package com.myorg.iplWinningPrediction.controller;

import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.repository.UserRepository;
import com.myorg.iplWinningPrediction.scheduler.WinningTeamSetScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {
    //variable for match start time and end time
    @Value("${matchStartingTime}")
    String startTime;
    @Value("${matchEndTime}")
    String endTime;
    //variable for save the user and
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    //guess the winner
    @PostMapping("/guess-the-winner/{value}/{id}")
    public User guessTheWinner(@PathVariable String value, @PathVariable String id){
        User user = userController.getUserById(id);
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        boolean isBeforeTime = currentTime.isBefore(LocalTime.parse(startTime));
        boolean isAfterTime = currentTime.isAfter(LocalTime.parse(endTime));
        boolean cond = isBeforeTime || isAfterTime;
        System.out.println(value +" "+id);
        if(Integer.parseInt(value) == WinningTeamSetScheduler.winner_team){
            user.setWin(true);
            user.setPlayForToday(true);

            userRepository.save(user);
            return user;
        }else {
            return user;
        }
    }



}
