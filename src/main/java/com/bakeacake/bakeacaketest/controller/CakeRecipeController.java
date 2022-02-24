package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CakeRecipeController extends ViewController implements Initializable {

    public TextField flourField;
    public TextField sugarField;
    public TextField eggsField;
    public TextField butterField;
    public TextField creamCheeseField;
    public TextField vanillaSugarField;
    public TextField milkField;
    public TextField oilField;
    public TextField gelatinField;
    public TextField cornFlourField;
    public TextField cocoaField;
    public TextField darkChocolateField;
    public TextField whiteChocolateField;
    public TextField saltField;
    public TextField bakingSodaField;
    public TextField bakingPowderField;
    public TextField confectionersSugarField;
    public TextField otherField;

    public TextField cakeTitleField;
    public ChoiceBox<Double> tinSize;
    private Double[] tins = {18.0, 20.0, 22.0};

    private CakeRecipeService cakeRecipeService = new CakeRecipeService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tinSize.getItems().addAll(tins);
        tinSize.setValue(18.0);


    }


    public void addCakeRecipe(ActionEvent actionEvent) {
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()), Double.parseDouble(sugarField.getText()),
                Double.parseDouble(eggsField.getText()), Double.parseDouble(butterField.getText()), Double.parseDouble(creamCheeseField.getText()),
                Double.parseDouble(vanillaSugarField.getText()), Double.parseDouble(milkField.getText()), Double.parseDouble(oilField.getText()),
                Double.parseDouble(gelatinField.getText()), Double.parseDouble(cornFlourField.getText()), Double.parseDouble(cocoaField.getText()),
                Double.parseDouble(darkChocolateField.getText()), Double.parseDouble(whiteChocolateField.getText()),
                Double.parseDouble(saltField.getText()), Double.parseDouble(bakingSodaField.getText()), Double.parseDouble(bakingPowderField.getText()),
                Double.parseDouble(confectionersSugarField.getText()), otherField.getText());


        try {

            if (tinSize.getValue().equals(20.0)) {
                cakeRecipeService.addCakeTin20(cake);
                cakeRecipeService.addCakeTin22(convertIngredients20to22());
                cakeRecipeService.addCakeTin18(convertIngredients20to18());

            } else if (tinSize.getValue().equals(18.0)) {
                cakeRecipeService.addCakeTin18(cake);
                cakeRecipeService.addCakeTin20(convertIngredients18to20());
                cakeRecipeService.addCakeTin22(convertIngredients18to22());
            } else if (tinSize.getValue().equals(22.0)) {
                cakeRecipeService.addCakeTin22(cake);
                cakeRecipeService.addCakeTin18(convertIngredients22to18());
                cakeRecipeService.addCakeTin20(convertIngredients22to20());
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
        showAlert(null, "Recipe added successfully", Alert.AlertType.INFORMATION);
        clear();

    }

    public Cake convertIngredients20to18(){
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) / 1.23, Double.parseDouble(sugarField.getText()) / 1.23,
                Double.parseDouble(eggsField.getText()) / 1.23, Double.parseDouble(butterField.getText()) / 1.23, Double.parseDouble(creamCheeseField.getText()) / 1.23,
                Double.parseDouble(vanillaSugarField.getText()) / 1.23, Double.parseDouble(milkField.getText()) / 1.23, Double.parseDouble(oilField.getText()) / 1.23,
                Double.parseDouble(gelatinField.getText()) / 1.23, Double.parseDouble(cornFlourField.getText()) / 1.23, Double.parseDouble(cocoaField.getText()) / 1.23,
                Double.parseDouble(darkChocolateField.getText()) / 1.23, Double.parseDouble(whiteChocolateField.getText()) / 1.23,
                Double.parseDouble(saltField.getText()) / 1.23, Double.parseDouble(bakingSodaField.getText()) / 1.23, Double.parseDouble(bakingPowderField.getText()) / 1.23,
                Double.parseDouble(confectionersSugarField.getText()) / 1.23, otherField.getText());

        return cake;
    }

    public Cake convertIngredients20to22(){
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) * 1.21, Double.parseDouble(sugarField.getText()) * 1.21,
                Double.parseDouble(eggsField.getText()) * 1.21, Double.parseDouble(butterField.getText()) * 1.21, Double.parseDouble(creamCheeseField.getText()) * 1.21,
                Double.parseDouble(vanillaSugarField.getText()) * 1.21, Double.parseDouble(milkField.getText()) * 1.21, Double.parseDouble(oilField.getText()) * 1.21,
                Double.parseDouble(gelatinField.getText()) * 1.21, Double.parseDouble(cornFlourField.getText()) * 1.21, Double.parseDouble(cocoaField.getText()) * 1.21,
                Double.parseDouble(darkChocolateField.getText()) * 1.21, Double.parseDouble(whiteChocolateField.getText()) * 1.21,
                Double.parseDouble(saltField.getText()) * 1.21, Double.parseDouble(bakingSodaField.getText()) * 1.21, Double.parseDouble(bakingPowderField.getText()) * 1.21,
                Double.parseDouble(confectionersSugarField.getText()) * 1.21, otherField.getText());
        return cake;
    }

    public Cake convertIngredients18to20(){
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) * 1.23, Double.parseDouble(sugarField.getText()) * 1.23,
                Double.parseDouble(eggsField.getText()) * 1.23, Double.parseDouble(butterField.getText()) * 1.23, Double.parseDouble(creamCheeseField.getText()) * 1.23,
                Double.parseDouble(vanillaSugarField.getText()) * 1.23, Double.parseDouble(milkField.getText()) * 1.23, Double.parseDouble(oilField.getText()) * 1.23,
                Double.parseDouble(gelatinField.getText()) * 1.23, Double.parseDouble(cornFlourField.getText()) * 1.23, Double.parseDouble(cocoaField.getText()) * 1.23,
                Double.parseDouble(darkChocolateField.getText()) * 1.23, Double.parseDouble(whiteChocolateField.getText()) * 1.23,
                Double.parseDouble(saltField.getText()) * 1.23, Double.parseDouble(bakingSodaField.getText()) * 1.23, Double.parseDouble(bakingPowderField.getText()) * 1.23,
                Double.parseDouble(confectionersSugarField.getText()) * 1.23, otherField.getText());
        return cake;
    }

    public Cake convertIngredients18to22() {
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) * 1.49, Double.parseDouble(sugarField.getText()) * 1.49,
                Double.parseDouble(eggsField.getText()) * 1.49, Double.parseDouble(butterField.getText()) * 1.49, Double.parseDouble(creamCheeseField.getText()) * 1.49,
                Double.parseDouble(vanillaSugarField.getText()) * 1.49, Double.parseDouble(milkField.getText()) * 1.49, Double.parseDouble(oilField.getText()) * 1.49,
                Double.parseDouble(gelatinField.getText()) * 1.49, Double.parseDouble(cornFlourField.getText()) * 1.49, Double.parseDouble(cocoaField.getText()) * 1.49,
                Double.parseDouble(darkChocolateField.getText()) * 1.49, Double.parseDouble(whiteChocolateField.getText()) * 1.49,
                Double.parseDouble(saltField.getText()) * 1.49, Double.parseDouble(bakingSodaField.getText()) * 1.49, Double.parseDouble(bakingPowderField.getText()) * 1.49,
                Double.parseDouble(confectionersSugarField.getText()) * 1.49, otherField.getText());
        return cake;
    }

    public Cake convertIngredients22to18() {
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) / 1.49, Double.parseDouble(sugarField.getText()) / 1.49,
                Double.parseDouble(eggsField.getText()) / 1.49, Double.parseDouble(butterField.getText()) / 1.49, Double.parseDouble(creamCheeseField.getText()) / 1.49,
                Double.parseDouble(vanillaSugarField.getText()) / 1.49, Double.parseDouble(milkField.getText()) / 1.49, Double.parseDouble(oilField.getText()) / 1.49,
                Double.parseDouble(gelatinField.getText()) / 1.49, Double.parseDouble(cornFlourField.getText()) / 1.49, Double.parseDouble(cocoaField.getText()) / 1.49,
                Double.parseDouble(darkChocolateField.getText()) / 1.49, Double.parseDouble(whiteChocolateField.getText()) / 1.49,
                Double.parseDouble(saltField.getText()) / 1.49, Double.parseDouble(bakingSodaField.getText()) / 1.49, Double.parseDouble(bakingPowderField.getText()) / 1.49,
                Double.parseDouble(confectionersSugarField.getText()) / 1.49, otherField.getText());
        return cake;
    }

    public Cake convertIngredients22to20(){
        Cake cake = new Cake(cakeTitleField.getText(), Double.parseDouble(flourField.getText()) / 1.21, Double.parseDouble(sugarField.getText()) / 1.21,
                Double.parseDouble(eggsField.getText()) / 1.21, Double.parseDouble(butterField.getText()) / 1.21, Double.parseDouble(creamCheeseField.getText()) / 1.21,
                Double.parseDouble(vanillaSugarField.getText()) / 1.21, Double.parseDouble(milkField.getText()) / 1.21, Double.parseDouble(oilField.getText()) / 1.21,
                Double.parseDouble(gelatinField.getText()) / 1.21, Double.parseDouble(cornFlourField.getText()) / 1.21, Double.parseDouble(cocoaField.getText()) / 1.21,
                Double.parseDouble(darkChocolateField.getText()) / 1.21, Double.parseDouble(whiteChocolateField.getText()) / 1.21,
                Double.parseDouble(saltField.getText()) / 1.21, Double.parseDouble(bakingSodaField.getText()) / 1.21, Double.parseDouble(bakingPowderField.getText()) / 1.21,
                Double.parseDouble(confectionersSugarField.getText()) / 1.21, otherField.getText());
        return cake;
    }



    public void clear() {
        cakeTitleField.clear();
        flourField.clear();
        sugarField.clear();
        eggsField.clear();
        butterField.clear();
        creamCheeseField.clear();
        vanillaSugarField.clear();
        milkField.clear();
        oilField.clear();
        gelatinField.clear();
        cornFlourField.clear();
        cocoaField.clear();
        darkChocolateField.clear();
        whiteChocolateField.clear();
        saltField.clear();
        bakingSodaField.clear();
        bakingPowderField.clear();
        confectionersSugarField.clear();
        otherField.clear();
    }


    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
