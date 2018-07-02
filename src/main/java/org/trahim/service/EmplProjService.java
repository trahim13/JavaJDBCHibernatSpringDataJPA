package org.trahim.service;

import org.trahim.bl.Util;
import org.trahim.dao.EmplProjDAO;
import org.trahim.entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {

    private Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO empl_proj (employee_id, project_id) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());

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
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<>();

        String sql = "SELECT * FROM EMPL_PROJ";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getInt("employee_id"));
                emplProj.setProjectId(resultSet.getInt("project_id"));

                emplProjList.add(emplProj);
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
        return emplProjList;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(int employeeId, int projectId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM empl_proj WHERE employee_id=? AND project_id=?";
        EmplProj emplProj = new EmplProj();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getInt("employee_id"));
            emplProj.setProjectId(resultSet.getInt("project_id"));

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
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE empl_proj SET employee_id=?, project_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());

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
    public void remove(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM empl_proj WHERE employee_id=? AND project_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());

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
