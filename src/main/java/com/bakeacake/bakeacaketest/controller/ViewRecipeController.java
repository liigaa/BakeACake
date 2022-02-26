package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewRecipeController extends ViewController implements Initializable {

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
    public Label cakeTitleField;
    public ChoiceBox<Double> tinSize;
    private Double[] tins = {18.0, 20.0, 22.0};


    private CakeRecipeService cakeRecipeService = new CakeRecipeService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{

            String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
            tinSize.getItems().addAll(tins);
            tinSize.setValue(18.0);

            if (tinSize.getValue().equals(20.0)){
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin20(cakeTitle);
                getIngredients(cake);
            }

            if (tinSize.getValue().equals(22.0)){
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin22(cakeTitle);
                getIngredients(cake);
            }

            if (tinSize.getValue().equals(18.0)){
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin18(cakeTitle);
                getIngredients(cake);
            }

        } catch (Exception e) {
            showAlert("Recipe load failed, please select cake!", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }


    }


    public void getIngredients (Cake cake){
        cakeTitleField.setText(cake.getCakeTitle());
        flourField.setText(String.valueOf(cake.getFlour()));
        sugarField.setText(String.valueOf(cake.getSugar()));
        eggsField.setText(String.valueOf(cake.getEggs()));
        butterField.setText(String.valueOf(cake.getButter()));
        creamCheeseField.setText(String.valueOf(cake.getCreamCheese()));
        vanillaSugarField.setText(String.valueOf(cake.getVanillaSugar()));
        milkField.setText(String.valueOf(cake.getMilk()));
        oilField.setText(String.valueOf(cake.getOil()));
        gelatinField.setText(String.valueOf(cake.getGelatin()));
        cornFlourField.setText(String.valueOf(cake.getCornFlour()));
        cocoaField.setText(String.valueOf(cake.getCocoa()));
        darkChocolateField.setText(String.valueOf(cake.getDarkChocolate()));
        whiteChocolateField.setText(String.valueOf(cake.getWhiteChocolate()));
        saltField.setText(String.valueOf(cake.getSalt()));
        bakingSodaField.setText(String.valueOf(cake.getBakingSoda()));
        bakingPowderField.setText(String.valueOf(cake.getBakingPowder()));
        confectionersSugarField.setText(String.valueOf(cake.getConfectionersSugar()));
        otherField.setText(cake.getOther());
    }



    public void returnToRecipes(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "all_recipes");
        }catch (Exception ex){
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void addToShoppingList (ActionEvent actionEvent) {
//        try {
//            changeScene(actionEvent, "home");
//        }catch (Exception ex){
//            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
//        }
    }




}

