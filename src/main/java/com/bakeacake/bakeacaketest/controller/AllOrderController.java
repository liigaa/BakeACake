package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Order;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllOrderController extends ViewController implements Initializable {
   @FXML ChoiceBox<String> statusField;
    private final String[] status = {"All", "Pending", "Delivered", "Canceled"};
   @FXML DatePicker startDataField;
   @FXML DatePicker endDataField;
   @FXML ListView<Order> listViewField;
    public Button homeButton;
   // private Integer user_id = DataManager.getInstance().getLoggedInUserId();
    OrderService orderService = new OrderService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusField.getItems().addAll(status);
        statusField.setValue("All");
        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
    }

    public void handleOderList(ActionEvent actionEvent) {
        if(statusField.getValue().equals("All")){
            if(startDataField.getValue() != null && endDataField.getValue() !=null){
                listViewField.getItems().clear();
                viewAllWithDateOrder();
            }else{
            listViewField.getItems().clear();
            viewAllOrders();}
        }else if(statusField.getValue().equals("Pending")){
            listViewField.getItems().clear();
            viewAllPendingOrders();
        }else if(statusField.getValue().equals("Delivered")){
            listViewField.getItems().clear();
           viewAllDeliveredOrders();
        }else if(statusField.getValue().equals("Canceled")){
            listViewField.getItems().clear();
           viewAllCanceledOrders();
        }
    }
    private void viewAllOrders(){
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOder());
            for(Order order1 : orders){
                Order order = new Order(order1.getClient(), order1.getCake(),order1.getTinSize(),
                        order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                        order1.getDescription(), order1.getStatus());
                listViewField.getItems().addAll(order);}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void viewAllWithDateOrder(){
        String startData = String.valueOf(startDataField.getValue());
        String endData = String.valueOf(endDataField.getValue());
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOderBetweenDate(startData, endData));
            for(Order order1 : orders){
                Order order = new Order(order1.getClient(), order1.getCake(),order1.getTinSize(),
                        order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                        order1.getDescription(), order1.getStatus());
                listViewField.getItems().addAll(order);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void viewAllPendingOrders(){
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllPendingOder());
            for(Order order1 : orders){
                Order order = new Order(order1.getClient(), order1.getCake(),order1.getTinSize(),
                        order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                        order1.getDescription(), order1.getStatus());
                listViewField.getItems().addAll(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void viewAllDeliveredOrders(){
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllDeliveredOder());
            for(Order order1 : orders){
                Order order = new Order(order1.getClient(), order1.getCake(),order1.getTinSize(),
                        order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                        order1.getDescription(), order1.getStatus());
                listViewField.getItems().addAll(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void viewAllCanceledOrders(){
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllCanceledOder());
            for(Order order1 : orders){
                Order order = new Order(order1.getClient(), order1.getCake(),order1.getTinSize(),
                        order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                        order1.getDescription(), order1.getStatus());
                listViewField.getItems().addAll(order );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void handleClientInfo(ActionEvent actionEvent) {

    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleLogout(ActionEvent actionEvent) {
        try {
            DataManager.getInstance().setLoggedInUserId(null);
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
