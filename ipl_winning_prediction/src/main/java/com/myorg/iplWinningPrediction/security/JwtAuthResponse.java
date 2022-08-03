package com.myorg.iplWinningPrediction.security;

import com.myorg.iplWinningPrediction.model.User;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    private User user;
    private String token;
}
