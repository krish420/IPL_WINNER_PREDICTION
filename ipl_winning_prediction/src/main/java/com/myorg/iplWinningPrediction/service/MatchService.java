package com.myorg.iplWinningPrediction.service;

import com.myorg.iplWinningPrediction.model.Matches;

import java.util.List;

public interface MatchService {
    String addMatches(Matches matches);

    List<Matches> getAllMatch();
    Matches getMathByDate(String date);
}
