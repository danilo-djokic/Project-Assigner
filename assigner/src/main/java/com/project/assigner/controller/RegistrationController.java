package com.project.assigner.controller;

import com.project.assigner.models.Role;
import com.project.assigner.models.dto.UserDto;
import com.project.assigner.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.assigner.service.UserService;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("listRoles", roleService.findAll());
        return "register";
    }
    @PostMapping
    public String processRegistration(UserDto userDto) {
        userDto.setRole(roleService.findById(userDto.getRoleId()));
        userService.save(userDto.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
