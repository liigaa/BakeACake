package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AllRecipesController extends ViewController implements Initializable {

    private CakeRecipeService cakeRecipeService = new CakeRecipeService();

    public ChoiceBox allCakesChoiceBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAllRecipes();


    }

    public void viewAllRecipes() {
        try {
            ObservableList<Cake> cakes = FXCollections.observableArrayList(this.cakeRecipeService.viewAllRecipes());
            allCakesChoiceBox.getItems().addAll(cakes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Delete recipe?!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            try {
                cakeRecipeService.deleteRecipeTin18(String.valueOf(allCakesChoiceBox.getValue()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                cakeRecipeService.deleteRecipeTin20(String.valueOf(allCakesChoiceBox.getValue()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                cakeRecipeService.deleteRecipeTin22(String.valueOf(allCakesChoiceBox.getValue()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            allCakesChoiceBox.getItems().clear();
            viewAllRecipes();

        }


    }


    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void viewRecipe(ActionEvent actionEvent) {

        DataManager.getInstance().setSelectedCakeTitle(String.valueOf(allCakesChoiceBox.getValue()));


        try {
            changeScene(actionEvent, "view_recipe");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void updateRecipe(ActionEvent actionEvent) {

    }


}
