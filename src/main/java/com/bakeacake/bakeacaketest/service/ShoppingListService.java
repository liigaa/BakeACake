package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.ShoppingList;
import com.bakeacake.bakeacaketest.repository.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingListService {
    private Connection connection = DBManager.getConnection();

    public ShoppingList viewShoppingList() throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT SUM(flour), SUM(sugar), SUM(eggs_grams), SUM(butter), SUM(cream_cheese), SUM(vanilla_sugar), SUM(milk)," +
                "SUM(oil), SUM(gelatin), SUM(corn_flour), SUM(cocoa), SUM(dark_chocolate), SUM(white_chocolate), SUM(salt)," +
                "SUM(baking_soda), SUM(baking_powder), SUM(confectioners_sugar), SUM(other) FROM shopping_list";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet result = preparedStatement.executeQuery();
        ShoppingList shoppingList = null;
        if (result.next()) {



            shoppingList = new ShoppingList(
                    result.getDouble("SUM(flour)"),
                    result.getDouble("SUM(sugar)"),
                    result.getDouble("SUM(eggs_grams)"),
                    result.getDouble("SUM(butter)"),
                    result.getDouble("SUM(cream_cheese)"),
                    result.getDouble("SUM(vanilla_sugar)"),
                    result.getDouble("SUM(milk)"),
                    result.getDouble("SUM(oil)"),
                    result.getDouble("SUM(gelatin)"),
                    result.getDouble("SUM(corn_flour)"),
                    result.getDouble("SUM(cocoa)"),
                    result.getDouble("SUM(dark_chocolate)"),
                    result.getDouble("SUM(white_chocolate)"),
                    result.getDouble("SUM(salt)"),
                    result.getDouble("SUM(baking_soda)"),
                    result.getDouble("SUM(baking_powder)"),
                    result.getDouble("SUM(confectioners_sugar)"),
                    result.getString("SUM(other)"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (shoppingList == null) throw new Exception("Shopping list not found!");
        return shoppingList;


    }

    public void clearShoppingList () throws SQLException {
        connection = DBManager.getConnection();

        String query = "DELETE FROM shopping_list";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();

    }
}
