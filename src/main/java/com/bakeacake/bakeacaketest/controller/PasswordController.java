package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordController extends ViewController implements Initializable {

    public PasswordField newPasswordField;
    public Button homeButton;
//    public TextField usernameField;
//    public TextField emailField;
//    public TextField answerField;
//    public ComboBox<String> secretQuestionBox;
//    private String [] secretQuestion = {"Your cat's name", "Your dog's name", "Your first teacher's name"};


    UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        //secretQuestionBox.getItems().addAll(secretQuestion);

    }

    public void changePassword(ActionEvent actionEvent) {

        Integer userId = DataManager.getInstance().getLoggedInUserId();
        try {
            this.userService.changePassword(userId, newPasswordField.getText());
            if (newPasswordField.getText().isEmpty() || newPasswordField.getText() == null ){
                showAlert(null, "New password field is empty. Please enter new password!", Alert.AlertType.INFORMATION);
                return;
            }
            changeScene(actionEvent, "home");
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

    public void handleLogout(ActionEvent actionEvent) {
        try {
            DataManager.getInstance().setLoggedInUserId(null);
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    public void resetPassword (ActionEvent actionEvent) {
//        try{
//            Integer userId = userService.verifyUserForResetPassword(usernameField.getText(), emailField.getText(),
//                    secretQuestionBox.getValue(), answerField.getText());
//            DataManager.getInstance().setLoggedInUserId(userId);
//            changeScene(actionEvent, "reset_password");
//        }catch (Exception e){
//            e.printStackTrace();
//            showAlert("Login Failed", e.getMessage(), Alert.AlertType.ERROR);
//        }
//
//    }
//
//    public void cancelResetPassword(ActionEvent actionEvent){
//        try{
//            changeScene(actionEvent, "login");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//    }




}
