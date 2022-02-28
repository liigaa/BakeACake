package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends ViewController implements Initializable {
    @FXML TextField nameField;
    @FXML TextField phoneField;
    @FXML TextField addressField;


    private UserService userService = new UserService();

    public void handleAddNewClient(ActionEvent actionEvent) {
        Client client = new Client(nameField.getText(), phoneField.getText(), addressField.getText());
        if(nameField.getText().isEmpty() || phoneField.getText().isEmpty()){
            showAlert(null, "Please provide name and phone number", Alert.AlertType.ERROR);
        }
        try {
            userService.addClient(client);
            showAlert(null, "Client " + nameField.getText() + " added successfully", Alert.AlertType.CONFIRMATION);
            changeScene(actionEvent, "add_order");
            clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try{
            changeScene(actionEvent, "order_screen");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
     private void clear(){
        nameField.clear();
        phoneField.clear();
        addressField.clear();
     }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
