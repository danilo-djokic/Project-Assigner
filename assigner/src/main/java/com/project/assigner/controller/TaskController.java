package com.project.assigner.controller;

import com.project.assigner.models.Project;
import com.project.assigner.models.Status;
import com.project.assigner.models.Task;
import com.project.assigner.models.User;
import com.project.assigner.models.dto.TaskCreationDto;
import com.project.assigner.service.StatusService;
import com.project.assigner.service.TaskService;
import com.project.assigner.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    private final StatusService statusService;

    private final UserService userService;

    @GetMapping()
    public String updateDesignForm(Model model, Authentication authentication){
        model.addAttribute("listTasks",taskService.findAllByUserId((((User)authentication.getPrincipal())).getId()));
        model.addAttribute("statusList",statusService.findAll());
        return "show-tasks";
    }

    @PostMapping("/{projectId}")
    public String addTask(@ModelAttribute Task task, @PathVariable Long projectId){
        Project project=new Project();
        project.setId(projectId);
        task.setProject(project);
        taskService.addNewTask(task);
        return "redirect:/projects/" + projectId;

    }

    @GetMapping("/add/{projectId}")
    public String showTaskForm(Model model, @PathVariable Long projectId){
        Task task= new Task();
        task.setUser(new User());
        task.setStatus(new Status());
        List<User> users = userService.findAllDevs();
        List<Status> statuses=statusService.findAll();
        model.addAttribute("userList",users);
        model.addAttribute("statusList",statuses);
        model.addAttribute(projectId);
        model.addAttribute("task", task);
        return "add-task";
    }
//    @GetMapping("/edit/{taskId}")
//    public String editTaskForm(Model model, @PathVariable Long taskId){
//        Task task = taskService.findById(taskId);
//        List<User> users = userService.findAllDevs();
//        model.addAttribute("userList", users);
//        model.addAttribute(taskId);
//        model.addAttribute(task);
//        return "edit-task";
//    }
    @PostMapping("/update")
    public String updateTask(@ModelAttribute TaskCreationDto form, Model model, Authentication authentication){
        taskService.updateAll(form.getTasks());
        model.addAttribute("tasks",taskService.findAllByUserId((((User)authentication.getPrincipal())).getId()));
        return "redirect:/tasks";
    }
//    @PostMapping("/edit")
//    public String updateTaskForm()
}
