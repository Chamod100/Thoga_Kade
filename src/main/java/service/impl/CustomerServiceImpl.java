package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.DTO.CustomerDTO;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addCustomerDetails(String CustID, String CustTitel, String CustName, String CustAddress, String City, String Province, String PostalCode, String DOB, double Salary) {

        customerRepository.addCustomer(CustID, CustTitel, CustName, CustAddress, City, Province, PostalCode, DOB, Salary);
    }

    @Override
    public void deleteCustomerDetails(String id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomerDetails(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary) {

        customerRepository.updateCustomer(id, title, name, address, city, province, postalCode, dob, salary);
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomerDetails() {

        ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList();

        try {
            ResultSet allCustomers = customerRepository.getAllCustomers();

            while (allCustomers.next()) {

                customerList.add(new CustomerDTO(
                        allCustomers.getString("CustID"),
                        allCustomers.getString("CustTitle"),
                        allCustomers.getString("CustName"),
                        allCustomers.getString("CustAddress"),
                        allCustomers.getString("City"),
                        allCustomers.getString("Province"),
                        allCustomers.getString("PostalCode"),
                        allCustomers.getString("DOB"),
                        allCustomers.getString("Salary")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerList;
    }
}

