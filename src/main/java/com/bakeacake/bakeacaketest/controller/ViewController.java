package com.bakeacake.bakeacaketest.controller;

import com.bakeacake.bakeacaketest.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class ViewController {

    public void changeScene(ActionEvent event, String sceneName) throws IOException {
        String scenePath = "/view/" + sceneName + ".fxml";
        System.out.println(scenePath);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scenePath)));
        stage.setScene(new Scene(parent, 650, 700));
        stage.show();
    }

    public void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);

        if (alertType.equals(Alert.AlertType.ERROR)){
            Image image = new Image(String.valueOf(Main.class.getResource("/images/error.png")));
            ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
        }
        if (alertType.equals(Alert.AlertType.INFORMATION)){
            Image image = new Image(String.valueOf(Main.class.getResource("/images/information.png")));
            ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
        }
       if (alertType.equals(Alert.AlertType.CONFIRMATION)){
            Image image = new Image(String.valueOf(Main.class.getResource("/images/question.png")));
            ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
        }

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Main.class.getResource("/images/favicon.png").toString()));
        alert.setHeaderText(null);
        alert.show();
    }
}
