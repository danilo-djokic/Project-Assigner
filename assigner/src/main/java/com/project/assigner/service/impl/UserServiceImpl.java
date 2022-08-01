package com.project.assigner.service.impl;

import com.project.assigner.models.User;
import com.project.assigner.repository.UserRepository;
import com.project.assigner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    //private final AuthenticationManager authenticationManager;

    public String signin(String email, String password) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//            return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRole());
//        } catch (AuthenticationException e) {
//            throw new CustomException("Invalid email/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
        return "logged in";
    }

    public List<User> findAllDevs() {
        return userRepository.findAllDevs();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}
