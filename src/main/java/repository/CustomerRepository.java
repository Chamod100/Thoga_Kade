package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {

    void addCustomer(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary);

    void deleteCustomer(String id);

    void updateCustomer(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary);

    ResultSet getAllCustomers() throws SQLException;

}

