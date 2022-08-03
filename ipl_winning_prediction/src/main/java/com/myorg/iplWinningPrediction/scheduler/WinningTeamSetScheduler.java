package com.myorg.iplWinningPrediction.scheduler;

import com.myorg.iplWinningPrediction.controller.MainController;
import com.myorg.iplWinningPrediction.controller.UserController;
import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
@Component
public class WinningTeamSetScheduler {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Value("${priceMoney}")
    private int priceMoney;
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    public static int winner_team = 1;

    //method for set the winning team
    @Scheduled(cron = "0 0/19 13 * * *")
    //@Scheduled(cron = "*/20 * * * * *")
    public void setWinnerTeam(){
        logger.warn("Winner team value is = {}",winner_team);
        Random random = new Random();
        winner_team = random.nextInt(2);
        logger.info("Winner team value set to {}",winner_team);
    }

    //reset the winner team to default
    @Scheduled(cron = "0 0/20 13 * * *")
    //@Scheduled(cron = "*/21 * * * * *")
    public void resetWinnerTeamToDefault(){
        List<User> userList = userController.getAllUser();
        for(User user : userList){
            if(user.isPlayForToday()) user.setPlayForToday(false);
            if(user.isWin()){
                user.setWin(false);
                user.setWalletBalance(user.getWalletBalance()+priceMoney);}
            userRepository.save(user);
        }
        logger.warn("Winner team value is = {}",winner_team);
        winner_team = -1;
        logger.info("Winner team value reset to {}",winner_team);
    }
}
