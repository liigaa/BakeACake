package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPasswordController extends ViewController implements Initializable {



    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    //public ComboBox<String> secretQuestionBox;
    //private final String[] secretQuestion = {"Your cat's name", "Your dog's name", "Your first teacher's name"};

    UserService userService = new UserService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    public void resetPassword (ActionEvent actionEvent){


        Integer userId = DataManager.getInstance().getLoggedInUserId();
        try {
            this.userService.changePassword(userId, passwordField.getText());
            if (passwordField.getText().isEmpty() || passwordField.getText() == null) {
                showAlert(null, "New password field is empty. Please enter new password!", Alert.AlertType.INFORMATION);
                return;
            }

            if (!(passwordField.getText().equals(confirmPasswordField.getText()))) {
                showAlert(null, "Password and Confirmation password doesn't mach", Alert.AlertType.ERROR);
                return;
            }
            showAlert(null, "Password changed successfully", Alert.AlertType.INFORMATION);
            changeScene(actionEvent, "home");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void cancelResetPassword(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




}
