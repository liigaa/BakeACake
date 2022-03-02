package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends ViewController implements Initializable {
    @FXML TextField nameField;
    @FXML TextField phoneField;
    @FXML TextField addressField;
    public Button homeButton;


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

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);

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
