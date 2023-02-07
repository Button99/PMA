package com.koumpis.pma.controllers;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String displayHome(Model model) {
        model.addAttribute("version", ver);
        return "main/Home";
    }
}
