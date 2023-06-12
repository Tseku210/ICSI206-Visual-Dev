package com.example.vehicle_dealer;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VehicleSaleController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnReceipt;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTotal;

    @FXML
    private ComboBox<String> cbChooseCar;

    @FXML
    private CheckBox cbCustom;

    @FXML
    private CheckBox cbGlobal;

    @FXML
    private CheckBox cbLeather;

    @FXML
    private CheckBox cbModified;

    @FXML
    private CheckBox cbStereo;

    @FXML
    private ComboBox<String> cbTradeCar;

    @FXML
    private TextArea taReceipt;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCarMileage;

    @FXML
    private TextField txtCostCar;

    @FXML
    private TextField txtCustom;

    @FXML
    private TextField txtGlobal;

    @FXML
    private TextField txtInterior;

    @FXML
    private TextField txtModified;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtStereo;

    @FXML
    private TextField txtSubTotal;

    @FXML
    private TextField txtTax;

    @FXML
    private TextField txtTelephone;

    @FXML
    private TextField txtTotal;

    private ObservableList<Car> cars = FXCollections.observableArrayList(
            new Car("Honda Civic",  40000, 20000),
            new Car("Toyota Corolla", 30000, 15000),
            new Car("Ford Mustang", 1000, 13000)
    );

    private ObservableList<String> tradIns = FXCollections.observableArrayList(
            "100-5000",
            "5001-10000",
            "10001-20000"
    );

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onReceipt(ActionEvent event) {
        double subTotal = 0;
        double total = 0;
        String name = txtName.getText();
        String address = txtAddress.getText();
        String postCode = txtPostalCode.getText();
        String telephone = txtTelephone.getText();
        double cost;
        if (txtCostCar.getText() == "") {
            cost = 0;
        } else {
            cost = Double.parseDouble(txtCostCar.getText());
        }
        subTotal += cost;
        if (cbModified.isSelected()) {
            subTotal += Double.parseDouble(txtModified.getText());
        }
        if (cbStereo.isSelected()) {
            subTotal += Double.parseDouble(txtStereo.getText());
        }
        if (cbLeather.isSelected()) {
            subTotal += Double.parseDouble(txtInterior.getText());
        }
        if (cbCustom.isSelected()) {
            subTotal += Double.parseDouble(txtCustom.getText());
        }
        if (cbGlobal.isSelected()) {
            subTotal += Double.parseDouble(txtGlobal.getText());
        }
        double tax = subTotal * 0.2;
        total += tax + subTotal;

        txtTax.setText("$" + tax);
        txtSubTotal.setText("$" + subTotal);
        txtTotal.setText("$" + total);

        taReceipt.setText(
                "Vehicle Sales Trading Management System\n" +
                "===================================" +
                "Name      " + name + "\n" +
                "Address   " + address + "\n" +
                "Pos Code  " + postCode + "\n" +
                "Telephone " + telephone + "\n" +
                "===================================\n" +
                "Tax       $" + tax + "\n" +
                "Sub Total $" + subTotal + "\n" +
                "Total     $" + total + "\n"
        );
    }

    @FXML
    void onReset(ActionEvent event) {
        txtAddress.clear();
        txtName.clear();
        txtCarMileage.clear();
        txtTax.clear();
        txtTotal.clear();
        txtCostCar.clear();
        txtPostalCode.clear();
        txtSubTotal.clear();
        txtTelephone.clear();
    }

    public void initialize() {

        ObservableList<String> carNames = FXCollections.observableArrayList();
        for (Car car: cars) {
            carNames.add(car.getName());
        }
        cbChooseCar.setItems(carNames);

        cbChooseCar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                Car selectedCar = null;
                for (Car car: cars) {
                    if (car.getName().equals(newValue)) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    txtCarMileage.setText(String.valueOf(selectedCar.getMileage()));
                    txtCostCar.setText(String.valueOf(selectedCar.getCost()));
                }
            }
        });

        cbTradeCar.getItems().addAll(tradIns);

//        cbTradeCar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                int val;
//                if (txtCostCar.getText() != "" && txtCarMileage.getText() != "") {
//                    if (newValue.equals("5001-10000")) {
//                        val = Integer.parseInt(txtCostCar.getText());
//                        txtCostCar.setText(String.valueOf((Integer)val * 0.9));
//                    } else if (newValue.equals("10001-20000")) {
//                        val = Integer.parseInt(txtCostCar.getText());
//                        txtCostCar.setText(String.valueOf((Integer)val * 0.7));
//                    }
//                }
//            }
//        });

        SimpleDoubleProperty carCost = new SimpleDoubleProperty();
        carCost.bind(Bindings.createObjectBinding(() -> {
            Car selectedCar = null;
            String selectedCarName = cbChooseCar.getSelectionModel().getSelectedItem();
            for (Car car: cars) {
                if (car.getName().equals(selectedCarName)) {
                    selectedCar = car;
                    break;
                }
            }

            return selectedCar != null ? selectedCar.getCost() : 0.0;
        }, cbChooseCar.getSelectionModel().selectedItemProperty()));

        SimpleDoubleProperty tradeInValue = new SimpleDoubleProperty();
        tradeInValue.bind(Bindings.createObjectBinding(() -> {
            String selectedValue = cbTradeCar.getSelectionModel().getSelectedItem();
            if (selectedValue != null) {
                String[] range = selectedValue.split("-");
                int min = Integer.parseInt(range[0]);
                int max = Integer.parseInt(range[1]);

                double carValue = carCost.get();
                if (carValue >= min && carValue <= max) {
                    return carValue * 0.9;
                } else if (carValue > max) {
                    return carValue * 0.7;
                }
            }
            return 0.0;
        }, cbTradeCar.getSelectionModel().selectedItemProperty()));

        SimpleDoubleProperty subTotal = new SimpleDoubleProperty();
        subTotal.bind(carCost.add(tradeInValue));
        SimpleDoubleProperty tax = new SimpleDoubleProperty();
        tax.bind(subTotal.multiply(0.2));
        SimpleDoubleProperty total = new SimpleDoubleProperty();
        total.bind(subTotal.add(tax));

        txtSubTotal.textProperty().bind(subTotal.asString());
        txtTax.textProperty().bind(tax.asString());
        txtTotal.textProperty().bind(total.asString());
    }
}