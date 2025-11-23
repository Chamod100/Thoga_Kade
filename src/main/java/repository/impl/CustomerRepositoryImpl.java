package repository.impl;

import db.DBConnection;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public ResultSet getAllCustomers() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        return preparedStatement.executeQuery();
    }

    @Override
    public void addCustomer(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, name);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, address);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE CustID = ?");

            pstm.setObject(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE customer SET CustTitle = ?, CustName = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ?, DOB = ?, Salary = ? WHERE CustID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, title);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, address);
            preparedStatement.setObject(4, city);
            preparedStatement.setObject(5, province);
            preparedStatement.setObject(6, postalCode);
            preparedStatement.setObject(7, dob);
            preparedStatement.setObject(8, salary);
            preparedStatement.setObject(9, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

