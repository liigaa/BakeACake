package com.bakeacake.bakeacaketest.controller;
import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.OrderService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientInfoController extends ViewController implements Initializable {
    @FXML Label clientLabel;
    @FXML Label phoneLabel;
    @FXML Label addressLabel;
    public Button homeButton;
    OrderService orderService = new OrderService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer client_id = DataManager.getInstance().getClientId();
        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        homeButton.setTooltip(new Tooltip("Home"));
        try {
            Client client = this.orderService.viewClientProfile(client_id);
            clientLabel.setText(client.getName() + " profile");
            phoneLabel.setText(client.getPhoneNumber());
            addressLabel.setText(client.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleUpdate(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "client_update");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "all_order");
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

    public void handleLogout(ActionEvent actionEvent) {
        try {
            DataManager.getInstance().setLoggedInUserId(null);
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
