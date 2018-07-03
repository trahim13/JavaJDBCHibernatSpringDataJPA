package org.trahim.hibernate.service;

import org.hibernate.Session;
import org.trahim.hibernate.bl.SessionUtil;
import org.trahim.hibernate.dao.EmployeeDAO;
import org.trahim.hibernate.entity.Employee;

import javax.persistence.Query;
import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {
    public void add(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Employee> getAll() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM employee";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.getResultList();

        //close session with a transaction
        closeTransactionSesstion();

        return employeeList;
    }

    public Employee getById(int id) {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM employee WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return employee;
    }

    public void update(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Employee employee) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
