package com.bakeacake.bakeacaketest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        Scene scene = new Scene(root, 700, 700);
//       scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
//        scene.getStylesheets().add("/stylesheet.css");

        String css = getClass().getResource("/view/stylesheet.css").toExternalForm();
//      String css = Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);

        stage.setTitle("Bake a Cake");
        Image icon = new Image(String.valueOf(Main.class.getResource("/images/favicon.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}