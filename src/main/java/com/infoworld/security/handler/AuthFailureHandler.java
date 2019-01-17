package com.infoworld.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFailureHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException{

        if(exception.getLocalizedMessage().equals("User is disabled")) {
            response.sendRedirect("loginInactiveJSON");
        }
        else if(exception.getLocalizedMessage().equals("Maximum sessions of 1 for this principal exceeded")){
            response.sendRedirect("loginMax1SessionJSON");
        }
        else {
            response.sendRedirect("loginFailureJSON");
        }
    }
}