package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.UserService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;


import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HomePageController extends ViewController implements Initializable {

    public ListView listViewAllUsers;


    public DatePicker datePicker;
    public Label welcomeLabel;
    public Label dateTime;

    UserService userService = new UserService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            initClock();
            addWelcomeText();


        } catch (Exception e) {
            showAlert("Main load failed", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();

        }


    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void addWelcomeText() {
        Integer userId = DataManager.getInstance().getLoggedInUserId();
        String name = null;
        try {
            name = userService.findNameById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        welcomeLabel.setText("Welcome " + name);
    }


//    public void getDate(ActionEvent actionEvent){
//        LocalDate myDate = datePicker.getValue();
//        System.out.println(myDate.toString());
//    }


    public void changePassword(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "password");
        } catch (Exception ex) {
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

    public void addNewRecipe(ActionEvent actionEvent) {

        try {
            changeScene(actionEvent, "new_recipe");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void viewRecipes(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "all_recipes");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addNewOrder() {

    }

    public void goToShoppingList() {

    }

    public void viewOrders() {

    }


}
