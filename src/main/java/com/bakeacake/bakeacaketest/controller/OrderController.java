package com.bakeacake.bakeacaketest.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController extends ViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleAddClient(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddOrder(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "add_order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
