package com.bakeacake.bakeacaketest.controller;


import com.bakeacake.bakeacaketest.model.ShoppingList;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.ShoppingListService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    public TextArea otherTextArea;
    public Button homeButton;
    public AnchorPane anchorPane; 
    public GridPane gridPane;
    public Label shoppingListLabel;
    public Label sourCreamField;


    private ShoppingListService shoppingListService = new ShoppingListService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        viewShoppingList();

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);


    }

    public void print(ActionEvent actionEvent) {
        Node node = new AnchorPane(shoppingListLabel, otherTextArea, gridPane, homeButton);

        PrinterJob job = PrinterJob.createPrinterJob();
        try {
            changeScene(actionEvent, "shopping_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (job != null) {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();

            }

        }

    }

    public void viewShoppingList() {

        try {
            Integer user_id = DataManager.getInstance().getLoggedInUserId();
            ShoppingList shoppingList = this.shoppingListService.viewShoppingList(user_id);
            ShoppingList shoppingList1 = this.shoppingListService.viewShoppingListOther(user_id);
            getIngredients(shoppingList);
            getOtherField(shoppingList1);

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
        sourCreamField.setText(String.valueOf(shoppingList.getSour_cream()));

    }

    public void getOtherField(ShoppingList shoppingList) {
        otherTextArea.setText(shoppingList.getOther());
    }


    public void returnHome(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception ex) {
            showAlert("Problem with navigation", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


    public void clearShoppingList(ActionEvent actionEvent) {

        try {
            Integer user_id = DataManager.getInstance().getLoggedInUserId();
            shoppingListService.clearShoppingList(user_id);
            try {
                changeScene(actionEvent, "shopping_list");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
