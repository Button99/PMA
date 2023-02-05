package com.koumpis.pma.controllers;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/new")
    public String displayProjectForm(Model model) {
        Project project= new Project();
        List<Employee> employeeList= employeeRepository.findAll();
        model.addAttribute("project", project);
        model.addAttribute("allEmployees", employeeList);
        return "projects/NewProject";
    }

    @GetMapping(value = "/ShowProjects")
    public String showProjects(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projects", projectList);
        return "projects/ProjectsList";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);
        return "redirect:/projects/new";
    }
}
