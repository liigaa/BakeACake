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
    public ChoiceBox<Integer> tinSize;
    private Integer[] tins = {18, 20, 22};

    private CakeRecipeService cakeRecipeService = new CakeRecipeService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tinSize.getItems().addAll(tins);
        tinSize.setValue(18);


    }


    public void addCakeRecipe(ActionEvent actionEvent) {
        Cake cake = new Cake(cakeTitleField.getText(), Integer.parseInt(flourField.getText()), Integer.parseInt(sugarField.getText()),
                Integer.parseInt(eggsField.getText()), Integer.parseInt(butterField.getText()), Integer.parseInt(creamCheeseField.getText()),
                Integer.parseInt(vanillaSugarField.getText()), Integer.parseInt(milkField.getText()), Integer.parseInt(oilField.getText()),
                Integer.parseInt(gelatinField.getText()), Integer.parseInt(cornFlourField.getText()), Integer.parseInt(cocoaField.getText()),
                Integer.parseInt(darkChocolateField.getText()), Integer.parseInt(whiteChocolateField.getText()),
                Integer.parseInt(saltField.getText()), Integer.parseInt(bakingSodaField.getText()), Integer.parseInt(bakingPowderField.getText()),
                Integer.parseInt(confectionersSugarField.getText()), otherField.getText());

        try {

            if (tinSize.getValue().equals(22)) {
                cakeRecipeService.addCakeTin22(cake);
            } else if (tinSize.getValue().equals(18)) {
                cakeRecipeService.addCakeTin18(cake);
            } else if (tinSize.getValue().equals(20)) {
                cakeRecipeService.addCakeTin20(cake);
            }



        } catch (SQLException e) {
            e.printStackTrace();

        }
        showAlert(null, "Recipe added successfully", Alert.AlertType.INFORMATION);
        clear();

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


//    public void addCakeRecipe(ActionEvent actionEvent) {
//        try {
//            changeScene(actionEvent, "profile");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    //  }

    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
