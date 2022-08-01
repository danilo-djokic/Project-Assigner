package com.project.assigner.controller;

import com.project.assigner.models.Project;
import com.project.assigner.models.Task;
import com.project.assigner.models.User;
import com.project.assigner.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public String showDesignForm(Model model, Authentication authentication){
        model.addAttribute("listProjects",projectService.findAllByUserId((((User)authentication.getPrincipal())).getId()));
        return "show-projects";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Project project= new Project();
        model.addAttribute("project", project);
        return "add-project";
    }

    @PostMapping
    public String addProject(@ModelAttribute Project project, Authentication authentication){
        project.setUser(((User)authentication.getPrincipal()));
        projectService.addProject(project);
        return "redirect:projects";
    }

    @GetMapping("/{id}")
    public String showProject(Model model, @PathVariable Long id){
        Project project = projectService.findById(id);
        model.addAttribute(id);
        model.addAttribute(project);
        return "project";
    }

}
