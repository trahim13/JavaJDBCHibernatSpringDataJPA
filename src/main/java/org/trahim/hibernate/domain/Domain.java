package org.trahim.hibernate.domain;

import org.hibernate.Session;
import org.trahim.hibernate.bl.HibernateUtil;
import org.trahim.hibernate.entity.Address;
import org.trahim.hibernate.entity.Employee;
import org.trahim.hibernate.entity.Project;
import org.trahim.jdbc.service.AddressService;
import org.trahim.jdbc.service.EmployeeService;
import org.trahim.jdbc.service.ProjectService;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        session.getTransaction().commit();
        session.close();


    }
}
