package org.trahim.hibernate.service;

import org.hibernate.Session;
import org.trahim.hibernate.bl.SessionUtil;

import org.trahim.hibernate.dao.AddressDAO;
import org.trahim.hibernate.entity.Address;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {

    public void add(Address address) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Address> getAll() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM address";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.getResultList();

        //close session with a transaction
        closeTransactionSesstion();

        return addressList;
    }

    public Address getById(int id)  {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM address WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return address;
    }

    public void update(Address address) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Address address) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        //close session with a transaction
        closeTransactionSesstion();
    }

}
