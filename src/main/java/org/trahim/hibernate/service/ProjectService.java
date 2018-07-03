package org.trahim.hibernate.service;

import org.hibernate.Session;
import org.trahim.hibernate.bl.SessionUtil;
import org.trahim.hibernate.dao.ProjectDAO;
import org.trahim.hibernate.entity.Project;

import javax.persistence.Query;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    public void add(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Project> getAll() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM project";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.getResultList();

        //close session with a transaction
        closeTransactionSesstion();

        return projectList;
    }

    public Project getById(int id) {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM project WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return project;
    }

    public void update(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
