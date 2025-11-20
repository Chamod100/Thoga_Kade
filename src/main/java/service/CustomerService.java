package service;

import javafx.collections.ObservableList;
import Model.DTO.CustomerDTO;

public interface CustomerService {

    void addCustomerDetails(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary);

    void deleteCustomerDetails(String id);

    void updateCustomerDetails(String id, String title, String name, String address, String city, String province, String postalCode, String dob, double salary);

    ObservableList<CustomerDTO> getAllCustomerDetails();
}

