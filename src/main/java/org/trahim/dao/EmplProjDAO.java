package org.trahim.dao;

import org.trahim.entity.EmplProj;
import org.trahim.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjDAO {
    void add(EmplProj emplProj) throws SQLException;

    List<EmplProj> getAll() throws SQLException;

    EmplProj getByEmployeeIdAndProjectId(int employeeId, int projectId) throws SQLException;

    void update(EmplProj emplProj) throws SQLException;

    void remove(EmplProj emplProj) throws SQLException;

}
