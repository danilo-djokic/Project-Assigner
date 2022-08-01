package com.project.assigner.service;

import com.project.assigner.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    void addProject(Project project);
    void deleteProject(Long id);

    List<Project> findAllByUserId(Long id);

    Project findById(Long id);
}
