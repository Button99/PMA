package com.koumpis.pma.controllers;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.repositories.EmployeeProject;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/new")
    public String displayEmployeeForm(Model model) {
        Employee employee= new Employee();
        model.addAttribute("employee", employee);
        return "/employees/NewEmployee";
    }

    @GetMapping(value = "/ShowEmployees")
    public String showEmployees(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        List<EmployeeProject> employeeProjects= employeeService.employeeProjects();
        model.addAttribute("employees", employeeList);
        model.addAttribute("employeesProject", employeeProjects);

        return "employees/EmployeesList";
    }

    @PostMapping(value = "/save")
    public String createEmployee(Model model, Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/new";
    }
}
