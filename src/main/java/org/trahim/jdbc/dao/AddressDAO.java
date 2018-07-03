package org.trahim.jdbc.dao;

import org.trahim.jdbc.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {
    void add(Address address) throws SQLException;

    List<Address> getAll() throws SQLException;

    Address getById(int id) throws SQLException;

    void update(Address address) throws SQLException;

    void remove(Address address) throws SQLException;

}
