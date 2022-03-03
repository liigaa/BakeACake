package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.User;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController extends ViewController implements Initializable {
    public Label notificationLabel;
    public TextField nameField;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public TextField emailField;

    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleRegistration(ActionEvent actionEvent) {
        User user = new User(nameField.getText(), usernameField.getText(), passwordField.getText(),
                emailField.getText());
        if (nameField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()
                || emailField.getText().isEmpty()) {
            showAlert(null, "Please provide name, username, password and email", Alert.AlertType.ERROR);
            return;
        }
        if (!(passwordField.getText().equals(confirmPasswordField.getText()))) {
            showAlert(null, "Password and Confirmation password doesn't mach", Alert.AlertType.ERROR);
            return;
        }

        try {

            userService.registerUser(user);
            showAlert(null, "Welcome " + nameField.getText() + "! Please login!", Alert.AlertType.INFORMATION);

//            try {
//                changeScene(actionEvent, "login");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Registration failed", e.getMessage() , Alert.AlertType.ERROR);
        }

    }
    public void handleLogin(ActionEvent actionEvent){
        try{
            changeScene(actionEvent, "login");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void handleCancelRegister(ActionEvent actionEvent){
        try{
            changeScene(actionEvent, "login");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


}
