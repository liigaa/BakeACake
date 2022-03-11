package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends ViewController implements Initializable {
    UserService userService = new UserService();


    public TextField usernameField;
    public PasswordField passwordField;
    public Button logInButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInButton.setDefaultButton(true);
    }

    public void handleUserLogin(ActionEvent actionEvent) {

        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
            showAlert(null, "Please enter username and password!", Alert.AlertType.ERROR);
            return;
        }

        try {
            Integer userId = userService.verifyUserDetail(usernameField.getText(), passwordField.getText());
            DataManager.getInstance().setLoggedInUserId(userId);
            changeScene(actionEvent, "home");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Login failed!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void handleLoadRegister(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "register");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void resetPassword(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "forgot_password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
