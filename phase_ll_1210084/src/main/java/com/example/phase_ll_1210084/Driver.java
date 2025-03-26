package com.example.phase_ll_1210084;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Driver extends Application {
    ArrayList<PizaaOrder> orders = new ArrayList<PizaaOrder>();
    Label customerNameLabel = new Label("Customer Name:");
    TextField customerName = new TextField();

    Label orderTypeLabel = new Label("Order Type:");
    ComboBox<String> orderType = new ComboBox<>();

    Label pizzaSizeLabel = new Label("Pizza Size:");
    ComboBox<Integer> pizzaSize = new ComboBox<>();

    Label toppingsLabel = new Label("Toppings:");
    CheckBox onion = new CheckBox("Onions");
    CheckBox olives = new CheckBox("Olives");
    CheckBox greenPeppers = new CheckBox("Green Peppers");

    Label toppingPriceLabel = new Label("Topping Price:");
    TextField toppingPrice = new TextField("10");

    Label orderPriceLabel = new Label("Order Price:");
    TextField orderPrice = new TextField("0.0");

    Label tripRateLabel = new Label("Trip Rate:");
    TextField tripRate = new TextField();

    Label zoneLabel = new Label("Zone:");
    TextField zone = new TextField();

    Label serviceChargeLabel = new Label("Service Charge:");
    TextField serviceCharge = new TextField();

    Label numberOfPeopleLabel = new Label("Number of People:");
    TextField numberOfPeople = new TextField();

    Button processOrderButton = new Button("Process Order");
    Button printOrdersButton = new Button("Print Orders");
    Button resetButton = new Button("Reset");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create GUI
        GridPane root = new GridPane();

        // Set orderType ComboBox items
        orderType.getItems().addAll("ToGo", "Delivery", "Seated");
        orderType.setValue("ToGo");

        // Set pizzaSize ComboBox items
        pizzaSize.getItems().addAll(1, 2, 3);
        pizzaSize.setValue(1);

        // Hide tripRate + zone OR serviceCharge + numberOfPeople labels and textfields
        tripRateLabel.setVisible(false);
        tripRate.setVisible(false);
        zoneLabel.setVisible(false);
        zone.setVisible(false);
        serviceChargeLabel.setVisible(false);
        serviceCharge.setVisible(false);
        numberOfPeopleLabel.setVisible(false);
        numberOfPeople.setVisible(false);

        // Add all items to the GridPane
        root.add(customerNameLabel, 0, 0);
        root.add(customerName, 1, 0);

        root.add(orderTypeLabel, 0, 1);
        root.add(orderType, 1, 1);

        root.add(pizzaSizeLabel, 0, 2);
        root.add(pizzaSize, 1, 2);

        root.add(toppingsLabel, 0, 3);
        root.add(onion, 1, 3);
        root.add(olives, 2, 3);
        root.add(greenPeppers, 3, 3);

        root.add(toppingPriceLabel, 0, 4);
        root.add(toppingPrice, 1, 4);

        root.add(orderPriceLabel, 0, 5);
        root.add(orderPrice, 1, 5);

        root.add(tripRateLabel, 0, 6);
        root.add(tripRate, 1, 6);

        root.add(zoneLabel, 0, 7);
        root.add(zone, 1, 7);

        root.add(serviceChargeLabel, 0, 8);
        root.add(serviceCharge, 1, 8);

        root.add(numberOfPeopleLabel, 0, 9);
        root.add(numberOfPeople, 1, 9);

        root.add(processOrderButton, 0, 10);
        root.add(printOrdersButton, 1, 10);
        root.add(resetButton, 2, 10);

        // Set action listeners
        orderType.setOnAction(e -> onOrderTypeChange());
        processOrderButton.setOnAction(e -> onProcessOrderButtonClick());
        printOrdersButton.setOnAction(e -> onPrintOrdersButtonClick());
        resetButton.setOnAction(e -> onResetButtonClick());

        // Create scene
        Scene scene = new Scene(root);

        // Set stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();
    }

    public void onOrderTypeChange() {
        if (orderType.getValue().equals("Delivery")) {
            tripRateLabel.setVisible(true);
            tripRate.setVisible(true);
            zoneLabel.setVisible(true);
            zone.setVisible(true);
            serviceChargeLabel.setVisible(false);
            serviceCharge.setVisible(false);
            numberOfPeopleLabel.setVisible(false);
            numberOfPeople.setVisible(false);
        } else {
            tripRateLabel.setVisible(false);
            tripRate.setVisible(false);
            zoneLabel.setVisible(false);
            zone.setVisible(false);
            if (orderType.getValue().equals("Seated")) {
                serviceChargeLabel.setVisible(true);
                serviceCharge.setVisible(true);
                numberOfPeopleLabel.setVisible(true);
                numberOfPeople.setVisible(true);
            } else {
                serviceChargeLabel.setVisible(false);
                serviceCharge.setVisible(false);
                numberOfPeopleLabel.setVisible(false);
                numberOfPeople.setVisible(false);
            }
        }
    }

    public void onProcessOrderButtonClick() {
        if (orderType.getValue().equals("Delivery")) {
            orders.add(new Delivery(
                    customerName.getText(),
                    pizzaSize.getValue(),
                    getSelectedToppingsNumber(),
                    Double.parseDouble(toppingPrice.getText()),
                    Double.parseDouble(tripRate.getText()),
                    Integer.parseInt(zone.getText())
            ));
        } else if (orderType.getValue().equals("Seated")) {
            orders.add(new Seated(
                    customerName.getText(),
                    pizzaSize.getValue(),
                    getSelectedToppingsNumber(),
                    Double.parseDouble(toppingPrice.getText()),
                    Double.parseDouble(serviceCharge.getText()),
                    Integer.parseInt(numberOfPeople.getText())
            ));
        } else {
            orders.add(new ToGo(
                    customerName.getText(),
                    pizzaSize.getValue(),
                    getSelectedToppingsNumber(),
                    Double.parseDouble(toppingPrice.getText())
            ));
        }

        orderPrice.setText(String.valueOf(orders.get(orders.size() - 1).calculateOrderPrice()));
    }

    public void onPrintOrdersButtonClick() {
        sortOrders(orders);

        StringBuilder sb = new StringBuilder();
        for (PizaaOrder order : orders) {
            sb.append(order.getCustomerName() + ": " + order.calculateOrderPrice() + "\n");
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(new Label(sb.toString())));
        stage.setTitle("Orders");
        stage.show();
    }

    public void onResetButtonClick() {
        orders.clear();

        customerName.setText("");
        orderType.setValue("ToGo");
        pizzaSize.setValue(1);
        onion.setSelected(false);
        olives.setSelected(false);
        greenPeppers.setSelected(false);
        toppingPrice.setText("10");
        orderPrice.setText("0.0");
        tripRate.setText("");
        zone.setText("");
        serviceCharge.setText("");
        numberOfPeople.setText("");

        onOrderTypeChange();
    }

    public int getSelectedToppingsNumber() {
        int toppingsNumber = 0;
        if (onion.isSelected()) {
            toppingsNumber++;
        }
        if (olives.isSelected()) {
            toppingsNumber++;
        }
        if (greenPeppers.isSelected()) {
            toppingsNumber++;
        }
        return toppingsNumber;
    }

    public static void sortOrders(ArrayList<PizaaOrder> orders) {
        Collections.sort(orders);
    }

    public static void main(String[] args) {
        launch(args);
    }}
