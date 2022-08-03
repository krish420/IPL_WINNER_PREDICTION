package com.myorg.iplWinningPrediction.filter;

import com.myorg.iplWinningPrediction.security.JwtTokenOperation;
import com.myorg.iplWinningPrediction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // for doing operation on jwt toke I declare JwtTokenOperation
    @Autowired
    private JwtTokenOperation jwtTokenOperation;
    // UserDetailsService
    @Autowired
    private UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1. fetch the jwt token from request
            //from the Header
        final String requestTokenHeader = request.getHeader("Authorization");
        //2. take the
        String username = null;
        String jwtToken = null;

        if(requestTokenHeader!= null && requestTokenHeader.startsWith("Bearer")){
            jwtToken = requestTokenHeader.substring(7);
            username = this.jwtTokenOperation.getUsernameFromToken(jwtToken);
        }
        //3. We get the token now time to validate
        if(username!= null && SecurityContextHolder.getContext().getAuthentication() ==null){
            final UserDetails userDetails = userService.loadUserByUsername(username);
            if(jwtTokenOperation.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        // All good now just move the request forward otherwise it will call the JwtAuthenticationEntryPoint
        filterChain.doFilter(request,response);
    }
}
