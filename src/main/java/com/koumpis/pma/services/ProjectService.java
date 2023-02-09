package com.koumpis.pma.services;

import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.ChartData;
import com.koumpis.pma.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project) {
        return  projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<ChartData> getProjectStatus() {
        return projectRepository.getProjectStatus();
    }
}
