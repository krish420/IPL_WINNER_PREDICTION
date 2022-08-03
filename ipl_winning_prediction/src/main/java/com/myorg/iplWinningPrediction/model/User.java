package com.myorg.iplWinningPrediction.model;

import lombok.*;

import javax.persistence.*;

@Entity @Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String userName;
    private String mobileNumber;
    private String password;
    @Transient
    private String confirmPassword;
    private double walletBalance;
    private String profilePicture;
    private boolean isPlayForToday;
    private boolean isWin;
}
