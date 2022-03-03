package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.ShoppingList;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.CakeRecipeService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewRecipeController extends ViewController implements Initializable {

    public Label sugarField;
    public Label flourField;
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
    public Label sourCreamField;
    public TextArea otherTextArea;
    public Label cakeTitleField;
    public ComboBox<Double> tinSize;
    private Double[] tins = {18.0, 20.0, 22.0};
    public Button homeButton;


    private CakeRecipeService cakeRecipeService = new CakeRecipeService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tinSize.getItems().addAll(tins);
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




    private Double convertField(String value){
        return  value.isEmpty()? 0.0 : Double.parseDouble(value);

    }


    public void addToShoppingList(ActionEvent actionEvent) {

        Cake cake = new Cake (cakeTitleField.getText(), convertField(flourField.getText()), convertField(sugarField.getText()),
                convertField(eggsField.getText()), convertField(butterField.getText()), convertField(creamCheeseField.getText()),
                convertField(vanillaSugarField.getText()), convertField(milkField.getText()), convertField(oilField.getText()),
                convertField(gelatinField.getText()), convertField(cornFlourField.getText()), convertField(cocoaField.getText()),
                convertField(darkChocolateField.getText()), convertField(whiteChocolateField.getText()),
                convertField(saltField.getText()), convertField(bakingSodaField.getText()), convertField(bakingPowderField.getText()),
                convertField(confectionersSugarField.getText()), convertField(sourCreamField.getText()), otherTextArea.getText());

        try {

            if (tinSize.getValue() == null){
                showAlert(null, "Please choose tin size", Alert.AlertType.ERROR);
                return;
            }
            this.cakeRecipeService.addToShoppingList(cake);

            showAlert(null, "Ingredients added to shopping list", Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Adding recipe failed!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }


    public void returnToRecipes(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "all_recipes");
        } catch (Exception ex) {
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
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



}

