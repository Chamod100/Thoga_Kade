package controller.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Model.DTO.CustomerDTO;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    CustomerService customerService = new CustomerServiceImpl();

    @FXML
    private TableView<CustomerDTO> tblCustomerView;

    @FXML
    private TableColumn<CustomerDTO, String> colCustID;

    @FXML
    private TableColumn<CustomerDTO, String> colCustTitel;

    @FXML
    private TableColumn<CustomerDTO, String> colCustName;

    @FXML
    private TableColumn<CustomerDTO, String> colCustAddress;

    @FXML
    private TableColumn<CustomerDTO, String> colCity;

    @FXML
    private TableColumn<CustomerDTO, String> colProvince;

    @FXML
    private TableColumn<CustomerDTO, String> colPostalCode;

    @FXML
    private TableColumn<CustomerDTO, String> colDOB;

    @FXML
    private TableColumn<CustomerDTO, Double> colSalary;

    @FXML
    private TextField txtCustID, txtTitel, txtName, txtAddress, txtCity, txtProvince, txtPostalCode, txtDOB, txtSalary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCustID.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        colCustTitel.setCellValueFactory(new PropertyValueFactory<>("CustTitel"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("Cust"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("Province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));

        loadAllCustomers();

        tblCustomerView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        setSelectedValue(newValue);
                    }
                });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String CustID = txtCustID.getText();
        String CustTitle = txtTitel.getText();
        String CustName = txtName.getText();
        String CustAddress = txtAddress.getText();
        String City = txtCity.getText();
        String Province = txtProvince.getText();
        String PostalCode = txtPostalCode.getText();
        String DOB = txtDOB.getText();
        double Salary = Double.parseDouble(txtSalary.getText());

        customerService.addCustomerDetails(CustID, CustTitle, CustName, CustAddress, City, Province, PostalCode, DOB, Salary);

        clearFields();
        loadAllCustomers();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerService.deleteCustomerDetails(txtCustID.getText());
        clearFields();
        loadAllCustomers();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String CustID = txtCustID.getText();
        String CustTitle = txtTitel.getText();
        String CustName = txtName.getText();
        String CustAddress = txtAddress.getText();
        String City = txtCity.getText();
        String Province = txtProvince.getText();
        String PostalCode = txtPostalCode.getText();
        String DOB = txtDOB.getText();
        double Salary = Double.parseDouble(txtSalary.getText());

        customerService.updateCustomerDetails(CustID, CustTitle, CustName, CustAddress, City, Province, PostalCode, DOB, Salary);

        clearFields();
        loadAllCustomers();
    }

    private void loadAllCustomers() {
        tblCustomerView.setItems(customerService.getAllCustomerDetails());
    }

    private void setSelectedValue(CustomerDTO c) {
        txtCustID.setText(c.getCustID());
        txtTitel.setText(c.getCustTitel());
        txtName.setText(c.getCustName());
        txtAddress.setText(c.getCustAddress());
        txtCity.setText(c.getCity());
        txtProvince.setText(c.getProvince());
        txtPostalCode.setText(c.getPostalCode());
        txtDOB.setText(c.getDOB());
        txtSalary.setText(String.valueOf(c.getSalary()));
    }

    private void clearFields() {
        txtCustID.clear();
        txtTitel.clear();
        txtName.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
        txtDOB.clear();
        txtSalary.clear();
    }
}
