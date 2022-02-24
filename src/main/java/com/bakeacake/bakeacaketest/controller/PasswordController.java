package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordController extends ViewController implements Initializable {

    public PasswordField newPasswordField;

    UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void changePassword(ActionEvent actionEvent) {

        Integer userId = DataManager.getInstance().getLoggedInUserId();
        try {
            this.userService.changePassword(userId, newPasswordField.getText());
            if (newPasswordField.getText().isEmpty() || newPasswordField.getText() == null ){
                showAlert(null, "New password field is empty. Please enter new password!", Alert.AlertType.INFORMATION);
                return;
            }
            //changeScene(actionEvent, "home");
            showAlert(null, "Password changed successfully", Alert.AlertType.INFORMATION);
            newPasswordField.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void returnHome(ActionEvent actionEvent){
        try{
            changeScene(actionEvent, "home");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



}
