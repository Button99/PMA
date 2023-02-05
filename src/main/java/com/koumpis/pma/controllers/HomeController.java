package com.koumpis.pma.controllers;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects= projectRepository.findAll();
        List<Employee> employees= employeeRepository.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/Home";
    }
}
