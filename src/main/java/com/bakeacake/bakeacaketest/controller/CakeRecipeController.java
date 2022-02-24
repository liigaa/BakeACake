package com.bakeacake.bakeacaketest.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CakeRecipeController extends ViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void addCakeRecipe(ActionEvent actionEvent) {
//        try {
//            changeScene(actionEvent, "profile");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }

    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
