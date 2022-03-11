package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.User;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController extends ViewController implements Initializable {

    public TextField nameField;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public TextField emailField;
    public ComboBox<String> secretQuestionBox;
    private String[] secretQuestion = {"Your cat's name", "Your dog's name", "Your first teacher's name"};
    public TextField answerField;

    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        secretQuestionBox.getItems().addAll(secretQuestion);
        secretQuestionBox.setValue("Your cat's name");

    }

    public void handleRegistration(ActionEvent actionEvent) {
        User user = new User(nameField.getText(), usernameField.getText(), passwordField.getText(),
                emailField.getText(), secretQuestionBox.getValue(), answerField.getText());
        if (nameField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()
                || emailField.getText().isEmpty() || answerField.getText().isEmpty()) {
            showAlert(null, "Please provide name, username, password, email and answer! ", Alert.AlertType.ERROR);
            return;
        }
        if (!(passwordField.getText().equals(confirmPasswordField.getText()))) {
            passwordField.clear();
            confirmPasswordField.clear();
            showAlert(null, "Password and confirmation password doesn't match!", Alert.AlertType.ERROR);
            return;
        }

        try {

            userService.registerUser(user);
            showAlert(null, "Welcome " + nameField.getText() + "! Please login!", Alert.AlertType.INFORMATION);

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Registration failed!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void handleLogin(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void handleCancelRegister(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
