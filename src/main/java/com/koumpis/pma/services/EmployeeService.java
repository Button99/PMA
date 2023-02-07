package com.koumpis.pma.services;

import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    IStaffRepository iStaffRepository;

    public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository iStaffRepository) {
        this.iStaffRepository = iStaffRepository;
    }
}
