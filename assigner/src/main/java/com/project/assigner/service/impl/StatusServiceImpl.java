package com.project.assigner.service.impl;

import com.project.assigner.models.Status;
import com.project.assigner.repository.StatusRepository;
import com.project.assigner.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
