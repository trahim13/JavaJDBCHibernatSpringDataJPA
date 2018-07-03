package org.trahim.hibernate.dao;



import org.trahim.hibernate.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee) throws SQLException;

    List<Employee> getAll() throws SQLException;

    Employee getById(int id) throws SQLException;

    void update(Employee employee) throws SQLException;

    void remove(Employee employee) throws SQLException;
}
