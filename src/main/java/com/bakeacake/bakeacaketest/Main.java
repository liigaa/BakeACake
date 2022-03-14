package com.bakeacake.bakeacaketest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene scene = new Scene(root, 650, 700);

        String css = getClass().getResource("/view/stylesheet.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);

        Font.loadFont(getClass().getResource("/font/ShintiaScript.otf").toExternalForm(), 10);

        stage.setTitle("BAKE A CAKE");
        Image icon = new Image(String.valueOf(Main.class.getResource("/images/stage_icon.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}