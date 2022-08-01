package com.project.assigner.security;

import com.project.assigner.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException{
        User user = (User) authentication.getPrincipal();
        String redirectUrl = request.getContextPath();

        if(user.hasRole("PM")){
            redirectUrl="projects";
        }
        else if(user.hasRole("DEV")){
            redirectUrl = "tasks";
        }

        response.sendRedirect(redirectUrl);
    }
}
