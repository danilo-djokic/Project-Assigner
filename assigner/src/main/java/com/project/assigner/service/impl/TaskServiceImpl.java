package com.project.assigner.service.impl;

import com.project.assigner.models.Project;
import com.project.assigner.models.Task;
import com.project.assigner.repository.TaskRepository;
import com.project.assigner.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public Task findById(Long task_id){
        return taskRepository.findById(task_id).orElseThrow(()->new RuntimeException("No task with that id") );
    }
    public void addNewTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId){
        boolean exists = taskRepository.existsById(taskId);
        if(!exists){
            throw new IllegalStateException("Task with id: " + taskId + " doesn't exist");
        }
        taskRepository.deleteById(taskId);
    }
    @Override
    public List<Task> findAllByUserId(Long id) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateAll(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
