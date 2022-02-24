package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.User;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController extends ViewController implements Initializable {
    public Label usernameLabel;
    public Label emailAddressLabel;
    public Label nameLabel;
    public Label createdAtLabel;
    public Label updatedAtLabel;


    private UserService userService = new UserService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Integer userId = DataManager.getInstance().getLoggedInUserId();
            User user = this.userService.getUserProfile(userId);
            nameLabel.setText(user.getName());
            usernameLabel.setText(user.getUsername());
            emailAddressLabel.setText(user.getEmail());
        } catch (Exception e) {
            showAlert("Profile load failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void handleReturnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        }catch (Exception ex){
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void handleChangePassword(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

