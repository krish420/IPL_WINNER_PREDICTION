package com.myorg.iplWinningPrediction.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Matches {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;
    private String teamA;
    private String teamB;
    private String date;
}
