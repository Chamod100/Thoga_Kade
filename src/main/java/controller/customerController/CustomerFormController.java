package controller.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Model.DTO.CustomerDTO;
import service.impl.CustomerServiceImpl;
import service.CustomerService;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    CustomerService customerService = new CustomerServiceImpl();

    @FXML
    private Button Add;

    @FXML
    private Button Clear;

    @FXML
    private Button Delete;

    @FXML
    private Button Update;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustTitel;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private AnchorPane tabelCust;

    @FXML
    private TableView<CustomerDTO> tblCustomerView;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustID.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        colCustTitel.setCellValueFactory(new PropertyValueFactory<>("CustTitle"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("Province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

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
        txtTitel.setText(c.getCustTitle());
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
