package com.bakeacake.bakeacaketest.controller;
import com.bakeacake.bakeacaketest.repository.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderController extends ViewController implements Initializable {
    public Button homeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        homeButton.setTooltip(new Tooltip("Home"));
    }

    public void handleAddClient(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddOrder(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "add_order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
        } catch (Exception e) {
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
