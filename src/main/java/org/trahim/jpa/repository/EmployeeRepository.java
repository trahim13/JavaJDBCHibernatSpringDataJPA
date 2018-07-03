package org.trahim.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.trahim.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM datajpa WHERE first_name=:first_name AND last_name=:last_name", nativeQuery = true)
    Employee findByFirstNameAndLastName(@Param("first_name") String firstName, @Param("last_name") String lastName);

    Employee findByLastName(String lastName);




}
