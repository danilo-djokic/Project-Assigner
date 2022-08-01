package com.project.assigner.service.impl;

import com.project.assigner.models.Project;
import com.project.assigner.repository.ProjectRepository;
import com.project.assigner.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;



    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        boolean exists = projectRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Project with id: "+ id + "doesn't exist.");
        }
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findAllByUserId(Long id) {
        return projectRepository.findAllByUserId(id);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(()->new RuntimeException("No project with that id") );
    }
}
