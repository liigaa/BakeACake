package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.ShoppingList;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import com.bakeacake.bakeacaketest.service.ShoppingListService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShoppingListController extends ViewController implements Initializable {

    public Label flourField;
    public Label sugarField;
    public Label eggsField;
    public Label butterField;
    public Label creamCheeseField;
    public Label vanillaSugarField;
    public Label milkField;
    public Label oilField;
    public Label gelatinField;
    public Label cornFlourField;
    public Label cocoaField;
    public Label darkChocolateField;
    public Label whiteChocolateField;
    public Label saltField;
    public Label bakingSodaField;
    public Label bakingPowderField;
    public Label confectionersSugarField;
    public Label otherField;


    //private CakeRecipeService cakeRecipeService = new CakeRecipeService();
    private ShoppingListService shoppingListService = new ShoppingListService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        viewShoppingList ();


      //  String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
       // Double tinSize = DataManager.getInstance().getSelectedTinSize();


    }

        public void viewShoppingList () {

            try {
                ShoppingList shoppingList = this.shoppingListService.viewShoppingList();
                getIngredients(shoppingList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    public void getIngredients(ShoppingList shoppingList) {
        flourField.setText(String.valueOf(shoppingList.getFlour()));
        sugarField.setText(String.valueOf(shoppingList.getSugar()));
        eggsField.setText(String.valueOf(shoppingList.getEggs()));
        butterField.setText(String.valueOf(shoppingList.getButter()));
        creamCheeseField.setText(String.valueOf(shoppingList.getCreamCheese()));
        vanillaSugarField.setText(String.valueOf(shoppingList.getVanillaSugar()));
        milkField.setText(String.valueOf(shoppingList.getMilk()));
        oilField.setText(String.valueOf(shoppingList.getOil()));
        gelatinField.setText(String.valueOf(shoppingList.getGelatin()));
        cornFlourField.setText(String.valueOf(shoppingList.getCornFlour()));
        cocoaField.setText(String.valueOf(shoppingList.getCocoa()));
        darkChocolateField.setText(String.valueOf(shoppingList.getDarkChocolate()));
        whiteChocolateField.setText(String.valueOf(shoppingList.getWhiteChocolate()));
        saltField.setText(String.valueOf(shoppingList.getSalt()));
        bakingSodaField.setText(String.valueOf(shoppingList.getBakingSoda()));
        bakingPowderField.setText(String.valueOf(shoppingList.getBakingPowder()));
        confectionersSugarField.setText(String.valueOf(shoppingList.getConfectionersSugar()));
        otherField.setText(shoppingList.getOther());
    }


            public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void saveShoppingList (ActionEvent actionEvent) {
//        try {
//            changeScene(actionEvent, "all_recipes");
//        } catch (Exception ex) {
//            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
//        }
    }

    public void clearShoppingList (ActionEvent actionEvent) {

        try {
            shoppingListService.clearShoppingList();
            try {
                changeScene(actionEvent, "shopping_list");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
