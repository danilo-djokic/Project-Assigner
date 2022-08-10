package com.project.assigner.models.dto;

import com.project.assigner.models.Role;
import com.project.assigner.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {
    String firstName;
    String lastName;
    String email;
    String password;

    Long roleId;

    Role role;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(firstName, lastName, email, passwordEncoder.encode(password), role);
    }
}
