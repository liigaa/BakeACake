package com.bakeacake.bakeacaketest.controller;
import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.OrderService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientUpdateController extends ViewController implements Initializable {
    @FXML Label clientLabel;
    @FXML TextField phoneField;
    @FXML TextArea addressField;
    public Button homeButton;
    OrderService orderService = new OrderService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer client_id = DataManager.getInstance().getClientId();
        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        homeButton.setTooltip(new Tooltip("Home"));
        try {
            Client client = orderService.viewClientProfile(client_id);
            phoneField.setText(client.getPhoneNumber());
            addressField.setText(client.getAddress());
            clientLabel.setText( "Update " + client.getName() + " profile!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleUpdate(ActionEvent actionEvent) {
        try {
            Integer client_id = DataManager.getInstance().getClientId();
            Client client = orderService.viewClientProfile(client_id);
            client.setPhoneNumber(phoneField.getText());
            client.setAddress(addressField.getText());
            this.orderService.updateClient(client, client_id);
            phoneField.clear();
            addressField.clear();
            showAlert(null, client.getName()+ " profile updated!", Alert.AlertType.INFORMATION);
            changeScene(actionEvent, "client_info");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "client_info");
        } catch (Exception e) {
            e.printStackTrace();
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
