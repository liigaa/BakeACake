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
    private Double convertField(String value){
        return  value.isEmpty()? 0.0 : Double.parseDouble(value);

    }

    public void addCakeRecipe(ActionEvent actionEvent) {
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()), convertField(sugarField.getText()),
                convertField(eggsField.getText()), convertField(butterField.getText()), convertField(creamCheeseField.getText()),
                convertField(vanillaSugarField.getText()), convertField(milkField.getText()), convertField(oilField.getText()),
                convertField(gelatinField.getText()), convertField(cornFlourField.getText()), convertField(cocoaField.getText()),
                convertField(darkChocolateField.getText()), convertField(whiteChocolateField.getText()),
                convertField(saltField.getText()), convertField(bakingSodaField.getText()), convertField(bakingPowderField.getText()),
                convertField(confectionersSugarField.getText()), otherField.getText());

//        if (cakeTitleField.getText().equalsIgnoreCase(cake.getCakeTitle())){
//            showAlert(null, "Cake with title already exists", Alert.AlertType.ERROR);
//            clear();
//            return;
//        }

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
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) / 1.23, convertField(sugarField.getText()) / 1.23,
                convertField(eggsField.getText()) / 1.23, convertField(butterField.getText()) / 1.23, convertField(creamCheeseField.getText()) / 1.23,
                convertField(vanillaSugarField.getText()) / 1.23, convertField(milkField.getText()) / 1.23, convertField(oilField.getText()) / 1.23,
                convertField(gelatinField.getText()) / 1.23, convertField(cornFlourField.getText()) / 1.23, convertField(cocoaField.getText()) / 1.23,
                convertField(darkChocolateField.getText()) / 1.23, convertField(whiteChocolateField.getText()) / 1.23,
                convertField(saltField.getText()) / 1.23, convertField(bakingSodaField.getText()) / 1.23, convertField(bakingPowderField.getText()) / 1.23,
                convertField(confectionersSugarField.getText()) / 1.23, otherField.getText());

        return cake;
    }

    public Cake convertIngredients20to22(){
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) * 1.21, convertField(sugarField.getText()) * 1.21,
                convertField(eggsField.getText()) * 1.21, convertField(butterField.getText()) * 1.21, convertField(creamCheeseField.getText()) * 1.21,
                convertField(vanillaSugarField.getText()) * 1.21, convertField(milkField.getText()) * 1.21, convertField(oilField.getText()) * 1.21,
                convertField(gelatinField.getText()) * 1.21, convertField(cornFlourField.getText()) * 1.21, convertField(cocoaField.getText()) * 1.21,
                convertField(darkChocolateField.getText()) * 1.21, convertField(whiteChocolateField.getText()) * 1.21,
                convertField(saltField.getText()) * 1.21, convertField(bakingSodaField.getText()) * 1.21, convertField(bakingPowderField.getText()) * 1.21,
                convertField(confectionersSugarField.getText()) * 1.21, otherField.getText());
        return cake;
    }

    public Cake convertIngredients18to20(){
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) * 1.23, convertField(sugarField.getText()) * 1.23,
                convertField(eggsField.getText()) * 1.23, convertField(butterField.getText()) * 1.23, convertField(creamCheeseField.getText()) * 1.23,
                convertField(vanillaSugarField.getText()) * 1.23, convertField(milkField.getText()) * 1.23, convertField(oilField.getText()) * 1.23,
                convertField(gelatinField.getText()) * 1.23, convertField(cornFlourField.getText()) * 1.23, convertField(cocoaField.getText()) * 1.23,
                convertField(darkChocolateField.getText()) * 1.23, convertField(whiteChocolateField.getText()) * 1.23,
                convertField(saltField.getText()) * 1.23, convertField(bakingSodaField.getText()) * 1.23, convertField(bakingPowderField.getText()) * 1.23,
                convertField(confectionersSugarField.getText()) * 1.23, otherField.getText());
        return cake;
    }

    public Cake convertIngredients18to22() {
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) * 1.49, convertField(sugarField.getText()) * 1.49,
                convertField(eggsField.getText()) * 1.49, convertField(butterField.getText()) * 1.49, convertField(creamCheeseField.getText()) * 1.49,
                convertField(vanillaSugarField.getText()) * 1.49, convertField(milkField.getText()) * 1.49, convertField(oilField.getText()) * 1.49,
                convertField(gelatinField.getText()) * 1.49, convertField(cornFlourField.getText()) * 1.49, convertField(cocoaField.getText()) * 1.49,
                convertField(darkChocolateField.getText()) * 1.49, convertField(whiteChocolateField.getText()) * 1.49,
                convertField(saltField.getText()) * 1.49, convertField(bakingSodaField.getText()) * 1.49, convertField(bakingPowderField.getText()) * 1.49,
                convertField(confectionersSugarField.getText()) * 1.49, otherField.getText());
        return cake;
    }

    public Cake convertIngredients22to18() {
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) / 1.49, convertField(sugarField.getText()) / 1.49,
                convertField(eggsField.getText()) / 1.49, convertField(butterField.getText()) / 1.49, convertField(creamCheeseField.getText()) / 1.49,
                convertField(vanillaSugarField.getText()) / 1.49, convertField(milkField.getText()) / 1.49, convertField(oilField.getText()) / 1.49,
                convertField(gelatinField.getText()) / 1.49, convertField(cornFlourField.getText()) / 1.49, convertField(cocoaField.getText()) / 1.49,
                convertField(darkChocolateField.getText()) / 1.49, convertField(whiteChocolateField.getText()) / 1.49,
                convertField(saltField.getText()) / 1.49, convertField(bakingSodaField.getText()) / 1.49, convertField(bakingPowderField.getText()) / 1.49,
                convertField(confectionersSugarField.getText()) / 1.49, otherField.getText());
        return cake;
    }

    public Cake convertIngredients22to20(){
        Cake cake = new Cake(cakeTitleField.getText(), convertField(flourField.getText()) / 1.21, convertField(sugarField.getText()) / 1.21,
                convertField(eggsField.getText()) / 1.21, convertField(butterField.getText()) / 1.21, convertField(creamCheeseField.getText()) / 1.21,
                convertField(vanillaSugarField.getText()) / 1.21, convertField(milkField.getText()) / 1.21, convertField(oilField.getText()) / 1.21,
                convertField(gelatinField.getText()) / 1.21, convertField(cornFlourField.getText()) / 1.21, convertField(cocoaField.getText()) / 1.21,
                convertField(darkChocolateField.getText()) / 1.21, convertField(whiteChocolateField.getText()) / 1.21,
                convertField(saltField.getText()) / 1.21, convertField(bakingSodaField.getText()) / 1.21, convertField(bakingPowderField.getText()) / 1.21,
                convertField(confectionersSugarField.getText()) / 1.21, otherField.getText());
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
