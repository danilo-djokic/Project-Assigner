package com.project.assigner.service;

import com.project.assigner.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface UserService extends UserDetailsService {
    String signin(String email, String password);

    void save(User user);
    List<User> findAllDevs();
}
