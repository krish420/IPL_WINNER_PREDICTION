package com.myorg.iplWinningPrediction.controller;

import com.myorg.iplWinningPrediction.model.Matches;
import com.myorg.iplWinningPrediction.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {
    @Autowired
    private MatchService matchService;

    //add matches
    @PostMapping("/add-match")
    public String addMatches(@RequestBody Matches matches){
        return this.matchService.addMatches(matches);
    }

    //get all match
    @GetMapping("/fetch-all-match")
    public List<Matches> getAllMatch(){
        return this.matchService.getAllMatch();
    }

    //found match by date
    @GetMapping("/fetch-today-match")
    public Matches findMatchByDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("M/dd/yyyy");
        String date = ""+formattedDate.format(currentDate);
        return this.matchService.getMathByDate(date);
    }
}
