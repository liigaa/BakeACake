package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.User;
import com.bakeacake.bakeacaketest.repository.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CakeRecipeService {

    private Connection connection = DBManager.getConnection();

    public void addCakeTin20(Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_20 (cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cake.getCakeTitle());
        preparedStatement.setInt(2, (int) cake.getFlour());
        preparedStatement.setInt(3, (int) cake.getSugar());
        preparedStatement.setInt(4, (int) cake.getEggs());
        preparedStatement.setInt(5, (int) cake.getButter());
        preparedStatement.setInt(6, (int) cake.getCreamCheese());
        preparedStatement.setInt(7, (int) cake.getVanillaSugar());
        preparedStatement.setInt(8, (int) cake.getMilk());
        preparedStatement.setInt(9, (int) cake.getOil());
        preparedStatement.setInt(10, (int) cake.getGelatin());
        preparedStatement.setInt(11, (int) cake.getCornFlour());
        preparedStatement.setInt(12, (int) cake.getCocoa());
        preparedStatement.setInt(13, (int) cake.getDarkChocolate());
        preparedStatement.setInt(14, (int) cake.getWhiteChocolate());
        preparedStatement.setInt(15, (int) cake.getSalt());
        preparedStatement.setInt(16, (int) cake.getBakingSoda());
        preparedStatement.setInt(17, (int) cake.getBakingPowder());
        preparedStatement.setInt(18, (int) cake.getConfectionersSugar());
        preparedStatement.setString(19, cake.getOther());


        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void addCakeTin18(Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_18 (cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cake.getCakeTitle());
        preparedStatement.setInt(2, (int) cake.getFlour());
        preparedStatement.setInt(3, (int) cake.getSugar());
        preparedStatement.setInt(4, (int) cake.getEggs());
        preparedStatement.setInt(5, (int) cake.getButter());
        preparedStatement.setInt(6, (int) cake.getCreamCheese());
        preparedStatement.setInt(7, (int) cake.getVanillaSugar());
        preparedStatement.setInt(8, (int) cake.getMilk());
        preparedStatement.setInt(9, (int) cake.getOil());
        preparedStatement.setInt(10, (int) cake.getGelatin());
        preparedStatement.setInt(11, (int) cake.getCornFlour());
        preparedStatement.setInt(12, (int) cake.getCocoa());
        preparedStatement.setInt(13, (int) cake.getDarkChocolate());
        preparedStatement.setInt(14, (int) cake.getWhiteChocolate());
        preparedStatement.setInt(15, (int) cake.getSalt());
        preparedStatement.setInt(16, (int) cake.getBakingSoda());
        preparedStatement.setInt(17, (int) cake.getBakingPowder());
        preparedStatement.setInt(18, (int) cake.getConfectionersSugar());
        preparedStatement.setString(19, cake.getOther());


        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void addCakeTin22(Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_22 (cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cake.getCakeTitle());
        preparedStatement.setInt(2, (int) cake.getFlour());
        preparedStatement.setInt(3, (int) cake.getSugar());
        preparedStatement.setInt(4, (int) cake.getEggs());
        preparedStatement.setInt(5, (int) cake.getButter());
        preparedStatement.setInt(6, (int) cake.getCreamCheese());
        preparedStatement.setInt(7, (int) cake.getVanillaSugar());
        preparedStatement.setInt(8, (int) cake.getMilk());
        preparedStatement.setInt(9, (int) cake.getOil());
        preparedStatement.setInt(10, (int) cake.getGelatin());
        preparedStatement.setInt(11, (int) cake.getCornFlour());
        preparedStatement.setInt(12, (int) cake.getCocoa());
        preparedStatement.setInt(13, (int) cake.getDarkChocolate());
        preparedStatement.setInt(14, (int) cake.getWhiteChocolate());
        preparedStatement.setInt(15, (int) cake.getSalt());
        preparedStatement.setInt(16, (int) cake.getBakingSoda());
        preparedStatement.setInt(17, (int) cake.getBakingPowder());
        preparedStatement.setInt(18, (int) cake.getConfectionersSugar());
        preparedStatement.setString(19, cake.getOther());

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }


}
