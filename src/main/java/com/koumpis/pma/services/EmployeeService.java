package com.koumpis.pma.services;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.repositories.EmployeeProject;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    IStaffRepository iStaffRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeProject> employeeProjects() {
        return employeeRepository.employeeProjects();
    }
    public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository iStaffRepository) {
        this.iStaffRepository = iStaffRepository;
    }
}
