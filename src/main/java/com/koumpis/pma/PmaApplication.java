package com.koumpis.pma;

import com.koumpis.pma.entities.Employee;
import com.koumpis.pma.entities.Project;
import com.koumpis.pma.repositories.EmployeeRepository;
import com.koumpis.pma.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PmaApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;
	public static void main(String[] args) {
		SpringApplication.run(PmaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Employee employee1= new Employee("John", "Test", "JohnTest@test.com");
			Employee employee2= new Employee("George", "Georgiou", "Georgeg@test.com");
			Employee employee3= new Employee("Theodore", "Georgiou", "Tgeo@test.com");
			Employee employee4= new Employee("TEst", "Test", "TEstTEst@test.com");


			Project project1= new Project("HelloPro", "NOTSTARTED", "This is a test");
			Project project2= new Project("World", "COMPLETED", "This is a test");
			Project project3= new Project("BUTTON", "INPROGRESS", "This is a test");

			project1.addEmployee(employee1);
			project1.addEmployee(employee2);
			project2.addEmployee(employee3);
			project3.addEmployee(employee1);

			employee1.setProjects(Arrays.asList(project1, project3));
			employee2.setProjects(Arrays.asList(project1));
			employee3.setProjects(Arrays.asList(project2));

			employeeRepository.save(employee1);
			employeeRepository.save(employee2);
			employeeRepository.save(employee3);

			projectRepository.save(project1);
			projectRepository.save(project3);
			projectRepository.save(project2);
		};
	}
}
