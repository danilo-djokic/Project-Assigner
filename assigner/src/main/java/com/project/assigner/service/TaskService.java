package com.project.assigner.service;

import com.project.assigner.models.Task;

import java.util.List;

public interface TaskService {


    Task findById(Long taskId);

    void addNewTask(Task task);

    void deleteTask(Long taskId);

    List<Task> findAllByUserId(Long id);


    void updateTask(Task task);

    void updateAll(List<Task> tasks);
}
