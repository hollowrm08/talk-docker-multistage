package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.data.UserDetailsData;
import com.example.demo.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private static final int TOKEN_EXPIRATION = 600000; //10 minutes
    private static final String TOKEN_PASSWORD = "${TOKEN_PASSWORD}";
    private static final String JSON_ATRIBUTE_NAME = "token";

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public static String getTokenPassword() {
        return TOKEN_PASSWORD;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getLogin(),
                    user.getPassword(),
                    new ArrayList<>()
                )
            );
            //Todo: Change authorities?
        } catch (IOException e) {
           throw new RuntimeException("Falha ao autenticar o usuario", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetailsData userDetailsData = (UserDetailsData) authResult.getPrincipal();

       String token = JWT.create()
               .withSubject(userDetailsData.getUsername())
               .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
               .sign(Algorithm.HMAC512(TOKEN_PASSWORD));

       response.getWriter().write(writeJsonObject(token));
       response.getWriter().flush();
    }

    private String writeJsonObject(String token){
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put(JSON_ATRIBUTE_NAME, JWTValidateFilter.getAtributePrefix() + token);
        return jsonResponse.toString();
    }

}
