package org.trahim.service;

import org.trahim.bl.Util;
import org.trahim.dao.AddressDAO;
import org.trahim.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {

    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO address (id, country, city, street, post_code) VALUES (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<>();

        String sql = "SELECT * FROM address";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("post_code"));

                addressList.add(address);
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
        return addressList;
    }

    @Override
    public Address getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM ADDRESS WHERE id=?";

        Address address = new Address();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setPostCode(resultSet.getString("post_code"));

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
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE address SET country=?, city=?, street=?, post_code=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setInt(5, address.getId());

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
    public void remove(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM address WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, address.getId());

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
