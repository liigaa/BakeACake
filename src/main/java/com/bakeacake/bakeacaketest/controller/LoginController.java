package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends ViewController implements Initializable {
    UserService userService = new UserService();

    public Label notificationLabel;
    public TextField usernameField;
    public PasswordField passwordField;
    public Button logInButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInButton.setDefaultButton(true);
    }

    public void handleUserLogin(ActionEvent actionEvent){

        try{
            Integer userId = userService.verifyUserDetail(usernameField.getText(), passwordField.getText());
            notificationLabel.setText("Login successful for " + usernameField.getText() + " User " + userId);
            DataManager.getInstance().setLoggedInUserId(userId);
            changeScene(actionEvent, "home");
        }catch (Exception e){
            e.printStackTrace();
            showAlert("Login Failed", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void handleLoadRegister(ActionEvent actionEvent){
        try{
            changeScene(actionEvent, "register");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



}
