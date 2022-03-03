package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateRecipeController extends ViewController implements Initializable {

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
    public TextField sourCreamField;
    public TextArea otherTextArea;
    public Label cakeTitleField;
    public ComboBox<Double> tinSize;
    private Double[] tins = {18.0, 20.0, 22.0};
    public Button homeButton;

    private CakeRecipeService cakeRecipeService = new CakeRecipeService();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tinSize.getItems().addAll(tins);
        tinSize.setOnAction(this::updateRecipe);
        tinSize.setOnAction(this::getRecipe);

        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        cakeTitleField.setText(cakeTitle);

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);




    }

    public void getRecipe(ActionEvent actionEvent) {

        try {

            String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();


            if (tinSize.getValue().equals(20.0)) {
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin20(cakeTitle);
                getIngredients(cake);
            }

            if (tinSize.getValue().equals(22.0)) {
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin22(cakeTitle);
                getIngredients(cake);
            }

            if (tinSize.getValue().equals(18.0)) {
                Cake cake = this.cakeRecipeService.getRecipeByCakeTitleTin18(cakeTitle);
                getIngredients(cake);
            }

        } catch (Exception e) {
            showAlert("Recipe load failed, please select cake!", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }






    private Double convertField(String value) {
        return value.isEmpty() ? 0.0 : Double.parseDouble(value);
    }


    public void updateRecipe(ActionEvent actionEvent) {


        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();


        Cake cake = new Cake(cakeTitle, convertField(flourField.getText()), convertField(sugarField.getText()),
                convertField(eggsField.getText()), convertField(butterField.getText()), convertField(creamCheeseField.getText()),
                convertField(vanillaSugarField.getText()), convertField(milkField.getText()), convertField(oilField.getText()),
                convertField(gelatinField.getText()), convertField(cornFlourField.getText()), convertField(cocoaField.getText()),
                convertField(darkChocolateField.getText()), convertField(whiteChocolateField.getText()),
                convertField(saltField.getText()), convertField(bakingSodaField.getText()), convertField(bakingPowderField.getText()),
                convertField(confectionersSugarField.getText()), convertField(sourCreamField.getText()), otherTextArea.getText());

        if (tinSize.getValue() == null){
            showAlert(null, "Please choose tin size", Alert.AlertType.ERROR);
            return;
        }


        try {

            if (tinSize.getValue().equals(20.0)) {
                cakeRecipeService.updateRecipeTinSize20(cake, cakeTitle);
                cakeRecipeService.updateRecipeTinSize22(convertIngredients20to22(), cakeTitle);
                cakeRecipeService.updateRecipeTinSize18(convertIngredients20to18(), cakeTitle);

            } else if (tinSize.getValue().equals(18.0)) {
                cakeRecipeService.updateRecipeTinSize18(cake, cakeTitle);
                cakeRecipeService.updateRecipeTinSize20(convertIngredients18to20(), cakeTitle);
                cakeRecipeService.updateRecipeTinSize22(convertIngredients18to22(), cakeTitle);
            } else if (tinSize.getValue().equals(22.0)) {
                cakeRecipeService.updateRecipeTinSize22(cake, cakeTitle);
                cakeRecipeService.updateRecipeTinSize18(convertIngredients22to18(), cakeTitle);
                cakeRecipeService.updateRecipeTinSize20(convertIngredients22to20(), cakeTitle);
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }

        showAlert(null, cakeTitle + " updated successfully", Alert.AlertType.INFORMATION);

        clear();


    }

    public Cake convertIngredients20to18(){
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle, convertField(flourField.getText()) / 1.23, convertField(sugarField.getText()) / 1.23,
                convertField(eggsField.getText()) / 1.23, convertField(butterField.getText()) / 1.23, convertField(creamCheeseField.getText()) / 1.23,
                convertField(vanillaSugarField.getText()) / 1.23, convertField(milkField.getText()) / 1.23, convertField(oilField.getText()) / 1.23,
                convertField(gelatinField.getText()) / 1.23, convertField(cornFlourField.getText()) / 1.23, convertField(cocoaField.getText()) / 1.23,
                convertField(darkChocolateField.getText()) / 1.23, convertField(whiteChocolateField.getText()) / 1.23,
                convertField(saltField.getText()) / 1.23, convertField(bakingSodaField.getText()) / 1.23, convertField(bakingPowderField.getText()) / 1.23,
                convertField(confectionersSugarField.getText()) / 1.23, convertField(sourCreamField.getText()) / 1.23, otherTextArea.getText());

        return cake;
    }

    public Cake convertIngredients20to22(){
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle,convertField(flourField.getText()) * 1.21, convertField(sugarField.getText()) * 1.21,
                convertField(eggsField.getText()) * 1.21, convertField(butterField.getText()) * 1.21, convertField(creamCheeseField.getText()) * 1.21,
                convertField(vanillaSugarField.getText()) * 1.21, convertField(milkField.getText()) * 1.21, convertField(oilField.getText()) * 1.21,
                convertField(gelatinField.getText()) * 1.21, convertField(cornFlourField.getText()) * 1.21, convertField(cocoaField.getText()) * 1.21,
                convertField(darkChocolateField.getText()) * 1.21, convertField(whiteChocolateField.getText()) * 1.21,
                convertField(saltField.getText()) * 1.21, convertField(bakingSodaField.getText()) * 1.21, convertField(bakingPowderField.getText()) * 1.21,
                convertField(confectionersSugarField.getText()) * 1.21, convertField(sourCreamField.getText()) * 1.21, otherTextArea.getText());
        return cake;
    }

    public Cake convertIngredients18to20(){
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle,convertField(flourField.getText()) * 1.23, convertField(sugarField.getText()) * 1.23,
                convertField(eggsField.getText()) * 1.23, convertField(butterField.getText()) * 1.23, convertField(creamCheeseField.getText()) * 1.23,
                convertField(vanillaSugarField.getText()) * 1.23, convertField(milkField.getText()) * 1.23, convertField(oilField.getText()) * 1.23,
                convertField(gelatinField.getText()) * 1.23, convertField(cornFlourField.getText()) * 1.23, convertField(cocoaField.getText()) * 1.23,
                convertField(darkChocolateField.getText()) * 1.23, convertField(whiteChocolateField.getText()) * 1.23,
                convertField(saltField.getText()) * 1.23, convertField(bakingSodaField.getText()) * 1.23, convertField(bakingPowderField.getText()) * 1.23,
                convertField(confectionersSugarField.getText()) * 1.23, convertField(sourCreamField.getText()) * 1.23, otherTextArea.getText());
        return cake;
    }

    public Cake convertIngredients18to22() {
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle, convertField(flourField.getText()) * 1.49, convertField(sugarField.getText()) * 1.49,
                convertField(eggsField.getText()) * 1.49, convertField(butterField.getText()) * 1.49, convertField(creamCheeseField.getText()) * 1.49,
                convertField(vanillaSugarField.getText()) * 1.49, convertField(milkField.getText()) * 1.49, convertField(oilField.getText()) * 1.49,
                convertField(gelatinField.getText()) * 1.49, convertField(cornFlourField.getText()) * 1.49, convertField(cocoaField.getText()) * 1.49,
                convertField(darkChocolateField.getText()) * 1.49, convertField(whiteChocolateField.getText()) * 1.49,
                convertField(saltField.getText()) * 1.49, convertField(bakingSodaField.getText()) * 1.49, convertField(bakingPowderField.getText()) * 1.49,
                convertField(confectionersSugarField.getText()) * 1.49, convertField(sourCreamField.getText()) * 1.49, otherTextArea.getText());
        return cake;
    }

    public Cake convertIngredients22to18() {
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle,convertField(flourField.getText()) / 1.49, convertField(sugarField.getText()) / 1.49,
                convertField(eggsField.getText()) / 1.49, convertField(butterField.getText()) / 1.49, convertField(creamCheeseField.getText()) / 1.49,
                convertField(vanillaSugarField.getText()) / 1.49, convertField(milkField.getText()) / 1.49, convertField(oilField.getText()) / 1.49,
                convertField(gelatinField.getText()) / 1.49, convertField(cornFlourField.getText()) / 1.49, convertField(cocoaField.getText()) / 1.49,
                convertField(darkChocolateField.getText()) / 1.49, convertField(whiteChocolateField.getText()) / 1.49,
                convertField(saltField.getText()) / 1.49, convertField(bakingSodaField.getText()) / 1.49, convertField(bakingPowderField.getText()) / 1.49,
                convertField(confectionersSugarField.getText()) / 1.49, convertField(sourCreamField.getText()) / 1.49, otherTextArea.getText());
        return cake;
    }

    public Cake convertIngredients22to20(){
        String cakeTitle = DataManager.getInstance().getSelectedCakeTitle();
        Cake cake = new Cake(cakeTitle,convertField(flourField.getText()) / 1.21, convertField(sugarField.getText()) / 1.21,
                convertField(eggsField.getText()) / 1.21, convertField(butterField.getText()) / 1.21, convertField(creamCheeseField.getText()) / 1.21,
                convertField(vanillaSugarField.getText()) / 1.21, convertField(milkField.getText()) / 1.21, convertField(oilField.getText()) / 1.21,
                convertField(gelatinField.getText()) / 1.21, convertField(cornFlourField.getText()) / 1.21, convertField(cocoaField.getText()) / 1.21,
                convertField(darkChocolateField.getText()) / 1.21, convertField(whiteChocolateField.getText()) / 1.21,
                convertField(saltField.getText()) / 1.21, convertField(bakingSodaField.getText()) / 1.21, convertField(bakingPowderField.getText()) / 1.21,
                convertField(confectionersSugarField.getText()) / 1.21, convertField(sourCreamField.getText()) / 1.21, otherTextArea.getText());
        return cake;
    }
    public void clear() {

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
        sourCreamField.clear();
        otherTextArea.clear();
    }



    public void getIngredients(Cake cake) {

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
        sourCreamField.setText(String.valueOf(cake.getSourCream()));
        otherTextArea.setText(cake.getOther());
    }

    public void returnToRecipes(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "all_recipes");
        } catch (Exception ex) {
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
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

    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
