package com.koumpis.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.ChartData;
import com.koumpis.pma.services.EmployeeService;
import com.koumpis.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/new")
    public String displayProjectForm(Model model) {
        Project project= new Project();
        List<Employee> employeeList= employeeService.getAll();
        model.addAttribute("project", project);
        model.addAttribute("allEmployees", employeeList);
        return "projects/NewProject";
    }

    @GetMapping(value = "/ShowProjects")
    public String showProjects(Model model) throws JsonProcessingException {
        List<Project> projectList = projectService.getAll();
        List<ChartData> projectData= projectService.getProjectStatus();
        Map<String, Object> map= new HashMap<>();
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString= objectMapper.writeValueAsString(projectData);
        model.addAttribute("projects", projectList);
        model.addAttribute("projectEmployees", projectData);
        model.addAttribute("projectStatusCnt", jsonString);
        return "projects/ProjectsList";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project, Model model) {
        projectService.save(project);
        return "redirect:/projects/new";
    }
}
