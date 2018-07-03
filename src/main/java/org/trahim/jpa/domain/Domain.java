package org.trahim.jpa.domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.trahim.jpa.entity.Employee;
import org.trahim.jpa.entity.Address;
import org.trahim.jpa.entity.Project;
import org.trahim.jpa.repository.AddressRepository;
import org.trahim.jpa.repository.EmployeeRepository;
import org.trahim.jpa.repository.ProjectRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

        Address address = new Address();
        address.setCountry("DD6");
        address.setCity("Gotham cityn");
        address.setStreet("Arkham street 1");
        address.setPostCode("543213");

        Project project = new Project();
        project.setTitle("Gotham PD3");


        addressRepository.save(address);
        projectRepository.save(project);





    }
}
