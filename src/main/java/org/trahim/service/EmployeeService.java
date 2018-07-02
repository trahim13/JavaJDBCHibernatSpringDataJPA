package org.trahim.service;

import org.trahim.bl.Util;
import org.trahim.dao.EmployeeDAO;
import org.trahim.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements EmployeeDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) " +
                "VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setLong(5, employee.getAddressId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressId(resultSet.getInt("address_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM ADDRESS WHERE id=?";

        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressId(resultSet.getInt("address_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE EMPLOYEE SET first_name=?, last_name=?, birthday=?, address_id=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getAddressId());
            preparedStatement.setInt(5, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM employee WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
