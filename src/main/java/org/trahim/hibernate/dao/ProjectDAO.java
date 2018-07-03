package org.trahim.hibernate.dao;



import org.trahim.hibernate.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {
    void add(Project project) throws SQLException;

    List<Project> getAll() throws SQLException;

    Project getById(int id) throws SQLException;

    void update(Project project) throws SQLException;

    void remove(Project project) throws SQLException;
}
