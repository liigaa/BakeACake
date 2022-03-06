package com.bakeacake.bakeacaketest.controller;
import com.bakeacake.bakeacaketest.model.Order;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.OrderService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderUpdateController extends ViewController implements Initializable {
    @FXML Label clientLabel;
    @FXML Label cakeLabel;
    @FXML
    ComboBox<String> tinSizeField;
    private final String[] tins = {"18.0", "20.0", "22.0"};
    @FXML
    DatePicker datePicker;
    @FXML
    TextField timeField;
    @FXML
    ChoiceBox<String> deliveryField;
    private final String[] choice = {"Pick-up", "Delivery"};
    @FXML
    TextArea descriptionField;
    @FXML
    ChoiceBox<String> statusField;
    private final String[] status = {"Pending", "Delivered", "Canceled"};
    public Button homeButton;
    private OrderService orderService = new OrderService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer order_id = DataManager.getInstance().getOrderId();
        try {
            tinSizeField.getItems().addAll(tins);
            deliveryField.getItems().addAll(choice);
            statusField.getItems().addAll(status);
            Order order = orderService.viewOrder(order_id);
            clientLabel.setText(order.getClient());
            cakeLabel.setText(order.getCake());
            tinSizeField.setValue(order.getTinSize());
            datePicker.setValue(LocalDate.parse(order.getDatePicker()));
            timeField.setText(order.getDeliveryTime());
            deliveryField.setValue(order.getDeliveryOptions());
            descriptionField.setText(order.getDescription());
            statusField.setValue(order.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        homeButton.setTooltip(new Tooltip("Home"));
    }
    public void handleUpdateOrder(ActionEvent actionEvent) {
        Integer order_id = DataManager.getInstance().getOrderId();
        try {
            Order order = orderService.viewOrder(order_id);
            order.setTinSize(tinSizeField.getValue());
            order.setDatePicker(String.valueOf(datePicker.getValue()));
            order.setDeliveryTime(timeField.getText());
            order.setDeliveryOptions(deliveryField.getValue());
            order.setDescription(descriptionField.getText());
            order.setStatus(statusField.getValue());
            this.orderService.updateOrder(order, order_id);
            showAlert(null, "order updated successfully", Alert.AlertType.INFORMATION);
            changeScene(actionEvent, "all_order");
        } catch (Exception e) {
            e.printStackTrace();
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
