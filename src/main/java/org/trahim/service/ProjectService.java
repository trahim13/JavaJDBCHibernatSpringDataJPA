package org.trahim.service;

import org.trahim.bl.Util;
import org.trahim.dao.ProjectDAO;
import org.trahim.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Util implements ProjectDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO project (id, title) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

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
    public List<Project> getAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();

        String sql = "SELECT ID, TITLE FROM PROJECT";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));

                projectList.add(project);
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
        return projectList;
    }

    @Override
    public Project getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM PROJECT WHERE id=?";

        Project project = new Project();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getInt("id"));
            project.setTitle(resultSet.getString("title"));

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
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE project SET title=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setInt(2, project.getId());

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
    public void remove(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM project WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, project.getId());

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
