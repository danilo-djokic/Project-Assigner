package com.project.assigner.models.dto;

import com.project.assigner.models.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaskCreationDto {
    private List<Task> tasks;


    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
