package com.example.crud;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea taAddress;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfCompName;

    @FXML
    private TextField tfContactName;

    @FXML
    private TextField tfContactTitle;

    @FXML
    private TextField tfCountry;

    @FXML
    private TextField tfCustId;

    @FXML
    private TextField tfFax;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfPostalCode;

    @FXML
    private TextField tfRegion;

    @FXML
    private TableColumn<?, ?> tvAddress;

    @FXML
    private TableColumn<?, ?> tvCity;

    @FXML
    private TableColumn<?, ?> tvCompName;

    @FXML
    private TableColumn<?, ?> tvContactName;

    @FXML
    private TableColumn<?, ?> tvContactTitle;

    @FXML
    private TableColumn<?, ?> tvCountry;

    @FXML
    private TableColumn<?, ?> tvCustomerId;

    @FXML
    private TableColumn<?, ?> tvFax;

    @FXML
    private TableColumn<?, ?> tvPhone;

    @FXML
    private TableColumn<?, ?> tvPostalCode;

    @FXML
    private TableColumn<?, ?> tvRegion;

    ObservableList<Customer> customers;

    @FXML
    void onAdd(ActionEvent event) {
        Customer customer = new Customer(
            tfCustId.getText(),
            tfCompName.getText(),
            tfContactName.getText(),
            tfContactTitle.getText(),
            taAddress.getText(),
            tfCity.getText(),
            tfRegion.getText(),
            tfPostalCode.getText(),
            tfCountry.getText(),
            tfPhone.getText(),
            tfFax.getText()
        );

        customers = tableView.getItems();

        customers.add(customer);

        clearAll();
    }

    @FXML
    void onCancel(ActionEvent event) {
        clearAll();
    }

    @FXML
    void onDelete(ActionEvent event) {
        Customer selectedCustomer = tableView.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            customers.remove(selectedCustomer);
            tableView.refresh();
        }
    }

    @FXML
    void onUpdate(ActionEvent event) {
        Customer selectedCustomer = tableView.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            selectedCustomer.setCompName(tfCompName.getText());
            selectedCustomer.setContactName(tfContactName.getText());
            selectedCustomer.setContactTitle(tfContactTitle.getText());
            selectedCustomer.setAddress(taAddress.getText());
            selectedCustomer.setCity(tfCity.getText());
            selectedCustomer.setRegion(tfRegion.getText());
            selectedCustomer.setPostalCode(tfPostalCode.getText());
            selectedCustomer.setCountry(tfCountry.getText());
            selectedCustomer.setPhone(tfPhone.getText());
            selectedCustomer.setFax(tfFax.getText());
        }

        tableView.refresh();

        clearAll();
    }

    private void clearAll() {
        tfCustId.clear();
        tfCompName.clear();
        tfContactName.clear();
        tfContactTitle.clear();
        taAddress.clear();
        tfCity.clear();
        tfRegion.clear();
        tfPostalCode.clear();
        tfCountry.clear();
        tfPhone.clear();
        tfFax.clear();
    }

    @FXML
    public void initialize() {
        tvCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvCompName.setCellValueFactory(new PropertyValueFactory<>("compName"));
        tvContactName.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        tvContactTitle.setCellValueFactory(new PropertyValueFactory<>("contactTitle"));
        tvAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tvCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tvRegion.setCellValueFactory(new PropertyValueFactory<>("region"));
        tvPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tvCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        tvPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tvFax.setCellValueFactory(new PropertyValueFactory<>("fax"));

        customers = FXCollections.observableArrayList();

        tableView.setItems(customers);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getClickCount() == 2) {
                    Customer selectedCustomer = tableView.getSelectionModel().getSelectedItem();

                    tfCustId.setText(selectedCustomer.getId());
                    tfCompName.setText(selectedCustomer.getCompName());
                    tfContactName.setText(selectedCustomer.getContactName());
                    tfContactTitle.setText(selectedCustomer.getContactTitle());
                    taAddress.setText(selectedCustomer.getAddress());
                    tfCity.setText(selectedCustomer.getCity());
                    tfRegion.setText(selectedCustomer.getRegion());
                    tfPostalCode.setText(selectedCustomer.getPostalCode());
                    tfCountry.setText(selectedCustomer.getCountry());
                    tfPhone.setText(selectedCustomer.getPhone());
                    tfFax.setText(selectedCustomer.getFax());
                }
            }
        });
    }
}