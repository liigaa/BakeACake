package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ResetPasswordController extends ViewController implements Initializable {

    public PasswordField newPasswordField;
    public Button homeButton;
    public TextField usernameField;
    public TextField emailField;
    public TextField answerField;
    public ComboBox<String> secretQuestionBox;
    private String [] secretQuestion = {"Your cat's name", "Your dog's name", "Your first teacher's name"};


    UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        secretQuestionBox.getItems().addAll(secretQuestion);

    }

    public void resetPassword (ActionEvent actionEvent) {
        try{
            Integer userId = userService.verifyUserForResetPassword(usernameField.getText(), emailField.getText(),
                    secretQuestionBox.getValue(), answerField.getText());
            DataManager.getInstance().setLoggedInUserId(userId);
            changeScene(actionEvent, "password");
        }catch (Exception e){
            e.printStackTrace();
            showAlert("Login Failed", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void cancelResetPassword(ActionEvent actionEvent){
        try{
            changeScene(actionEvent, "login");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
