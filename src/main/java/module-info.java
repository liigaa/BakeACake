module com.bakeacake.bakeacaketest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.configuration;
    requires lombok;


    opens com.bakeacake.bakeacaketest to javafx.fxml;
    exports com.bakeacake.bakeacaketest;
    exports com.bakeacake.bakeacaketest.controller;
    opens com.bakeacake.bakeacaketest.controller to javafx.fxml;
}