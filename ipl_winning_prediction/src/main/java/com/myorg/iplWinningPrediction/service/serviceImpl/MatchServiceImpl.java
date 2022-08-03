package com.myorg.iplWinningPrediction.service.serviceImpl;

import com.myorg.iplWinningPrediction.model.Matches;
import com.myorg.iplWinningPrediction.repository.MatchRepository;
import com.myorg.iplWinningPrediction.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    MatchRepository matchRepository;
    @Override
    public String addMatches(Matches matches) {
        this.matchRepository.save(matches);
        return "Match Added";
    }

    @Override
    public List<Matches> getAllMatch() {
        return this.matchRepository.findAll();
    }

    @Override
    public Matches getMathByDate(String date) {
        Matches foundMatch = new Matches();
        List<Matches> matchList = getAllMatch();
        for(Matches matches : matchList){
            if(matches.getDate().equalsIgnoreCase(date)){
                foundMatch = matches;
                break;
            }


        }
        return foundMatch;
    }
}
