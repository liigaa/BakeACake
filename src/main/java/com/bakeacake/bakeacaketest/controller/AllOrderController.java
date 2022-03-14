package com.bakeacake.bakeacaketest.controller;
import com.bakeacake.bakeacaketest.model.Order;
import com.bakeacake.bakeacaketest.repository.DataManager;
import com.bakeacake.bakeacaketest.service.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class AllOrderController extends ViewController implements Initializable {
    @FXML
    ChoiceBox<String> statusField;
    private final String[] status = {"All", "Pending", "Delivered", "Canceled"};
    @FXML
    DatePicker startDataField;
    @FXML
    DatePicker endDataField;
    @FXML
    ListView<Order> listViewField;
    public Button homeButton;
    private Integer user_id = DataManager.getInstance().getLoggedInUserId();
    OrderService orderService = new OrderService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusField.getItems().addAll(status);
        statusField.setValue(DataManager.getInstance().getOrderStatus());
        startDataField.setValue(null);
        endDataField.setValue(null);
        if (statusField.getValue().equals("All")) viewAllOrders();
        if (statusField.getValue().equals("Pending")) viewAllPendingOrders();
        if (statusField.getValue().equals("Delivered")) viewAllDeliveredOrders();
        if (statusField.getValue().equals("Canceled")) viewAllCanceledOrders();

        ImageView imageView = new ImageView(getClass().getResource("/images/favicon.png").toExternalForm());
        homeButton.setGraphic(imageView);
        homeButton.setTooltip(new Tooltip("Home"));
    }

    public void handleOderList(ActionEvent actionEvent) {
        if (statusField.getValue().equals("All")) {
            if (startDataField.getValue() != null || endDataField.getValue() != null) {
                listViewField.getItems().clear();
                viewAllWithDateOrder();
            } else {
                listViewField.getItems().clear();
                viewAllOrders();
            }
        } else if (statusField.getValue().equals("Pending")) {
            if (startDataField.getValue() != null || endDataField.getValue() != null) {
                listViewField.getItems().clear();
                viewPendingWithDateOrder();
            } else {
                listViewField.getItems().clear();
                viewAllPendingOrders();
            }
        } else if (statusField.getValue().equals("Delivered")) {
            if (startDataField.getValue() != null || endDataField.getValue() != null) {
                listViewField.getItems().clear();
                viewDeliveredWithDateOrder();
            } else {
                listViewField.getItems().clear();
                viewAllDeliveredOrders();
            }
        } else if (statusField.getValue().equals("Canceled")) {
            if (startDataField.getValue() != null || endDataField.getValue() != null) {
                listViewField.getItems().clear();
                viewCanceledWithDateOrder();
            } else {
                listViewField.getItems().clear();
                viewAllCanceledOrders();
            }
        }
    }

    private void viewAllOrders() {
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOder(this.user_id));
            lookForOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewAllWithDateOrder() {
        String startData = String.valueOf(startDataField.getValue());
        String endData = String.valueOf(endDataField.getValue());
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOderBetweenDate(this.user_id, startData, endData));
            lookForOrders(orders);
            startDataField.setValue(null);
            endDataField.setValue(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewAllPendingOrders() {
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllPendingOder(this.user_id));
            lookForOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewPendingWithDateOrder() {
        String startData = String.valueOf(startDataField.getValue());
        String endData = String.valueOf(endDataField.getValue());
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewPendingOderBetweenDate(this.user_id, startData, endData));
            lookForOrders(orders);
            startDataField.setValue(null);
            endDataField.setValue(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void lookForOrders(ObservableList<Order> orders) {
        for (Order order1 : orders) {
            Order order = new Order(order1.getClient(), order1.getCake(), order1.getTinSize(),
                    order1.getDatePicker(), order1.getDeliveryTime(), order1.getDeliveryOptions(),
                    order1.getDescription(), order1.getStatus());
            listViewField.getItems().addAll(order);
        }
    }

    private void viewAllDeliveredOrders() {
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllDeliveredOder(this.user_id));
            lookForOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewDeliveredWithDateOrder() {
        String startData = String.valueOf(startDataField.getValue());
        String endData = String.valueOf(endDataField.getValue());
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewDeliveredOderBetweenDate(this.user_id, startData, endData));
            lookForOrders(orders);
            startDataField.setValue(null);
            endDataField.setValue(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewAllCanceledOrders() {
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllCanceledOder(this.user_id));
            lookForOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewCanceledWithDateOrder() {
        String startData = String.valueOf(startDataField.getValue());
        String endData = String.valueOf(endDataField.getValue());
        try {
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewCanceledOderBetweenDate(this.user_id, startData, endData));
            lookForOrders(orders);
            startDataField.setValue(null);
            endDataField.setValue(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleClientInfo(ActionEvent actionEvent) {
        try {
            String setStatus = statusField.getValue();
            DataManager.getInstance().setOrderStatus(setStatus);
            if(!listViewField.getSelectionModel().isEmpty()){
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOder(this.user_id));
            String name = listViewField.getSelectionModel().getSelectedItem().getClient();
            String title = listViewField.getSelectionModel().getSelectedItem().getCake();
            String status = listViewField.getSelectionModel().getSelectedItem().getStatus();
            for (Order order : orders) {
                if (order.getClient().equals(name) && order.getCake().equals(title)
                        && order.getStatus().equals(status)) {
                    DataManager.getInstance().setClientId(order.getClient_id());
                    changeScene(actionEvent, "client_info");
                }
            }}else {
                showAlert(null, "Please select order!", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleOrderUpdate(ActionEvent actionEvent) {
        try {
            String setStatus = statusField.getValue();
            DataManager.getInstance().setOrderStatus(setStatus);
            if(!listViewField.getSelectionModel().isEmpty()){
            ObservableList<Order> orders = FXCollections.observableArrayList(this.orderService.viewAllOder(this.user_id));
            String name = listViewField.getSelectionModel().getSelectedItem().getClient();
            String title = listViewField.getSelectionModel().getSelectedItem().getCake();
            String status = listViewField.getSelectionModel().getSelectedItem().getStatus();
            for (Order order : orders) {
                if (order.getClient().equals(name) && order.getCake().equals(title)
                        && order.getStatus().equals(status)) {
                    DataManager.getInstance().setOrderId(order.getId());
                    changeScene(actionEvent, "order_update");
                }
            }}else {
                showAlert(null, "Please select order!", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleReturn(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, "home");
            DataManager.getInstance().setOrderStatus("Pending");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleLogout(ActionEvent actionEvent) {
        try {
            DataManager.getInstance().setLoggedInUserId(null);
            DataManager.getInstance().setOrderStatus("Pending");
            changeScene(actionEvent, "login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
