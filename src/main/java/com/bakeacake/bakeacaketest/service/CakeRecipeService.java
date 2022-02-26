package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.repository.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CakeRecipeService {

    private Connection connection = DBManager.getConnection();

    public void addCakeTin20(Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_20 (cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cake.getCakeTitle());
        preparedStatement.setDouble(2, cake.getFlour());
        preparedStatement.setDouble(3, cake.getSugar());
        preparedStatement.setDouble(4, cake.getEggs());
        preparedStatement.setDouble(5, cake.getButter());
        preparedStatement.setDouble(6, cake.getCreamCheese());
        preparedStatement.setDouble(7, cake.getVanillaSugar());
        preparedStatement.setDouble(8, cake.getMilk());
        preparedStatement.setDouble(9, cake.getOil());
        preparedStatement.setDouble(10, cake.getGelatin());
        preparedStatement.setDouble(11, cake.getCornFlour());
        preparedStatement.setDouble(12, cake.getCocoa());
        preparedStatement.setDouble(13, cake.getDarkChocolate());
        preparedStatement.setDouble(14, cake.getWhiteChocolate());
        preparedStatement.setDouble(15, cake.getSalt());
        preparedStatement.setDouble(16, cake.getBakingSoda());
        preparedStatement.setDouble(17, cake.getBakingPowder());
        preparedStatement.setDouble(18, cake.getConfectionersSugar());
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
        preparedStatement.setDouble(2, cake.getFlour());
        preparedStatement.setDouble(3, cake.getSugar());
        preparedStatement.setDouble(4, cake.getEggs());
        preparedStatement.setDouble(5, cake.getButter());
        preparedStatement.setDouble(6, cake.getCreamCheese());
        preparedStatement.setDouble(7, cake.getVanillaSugar());
        preparedStatement.setDouble(8, cake.getMilk());
        preparedStatement.setDouble(9, cake.getOil());
        preparedStatement.setDouble(10, cake.getGelatin());
        preparedStatement.setDouble(11, cake.getCornFlour());
        preparedStatement.setDouble(12, cake.getCocoa());
        preparedStatement.setDouble(13, cake.getDarkChocolate());
        preparedStatement.setDouble(14, cake.getWhiteChocolate());
        preparedStatement.setDouble(15, cake.getSalt());
        preparedStatement.setDouble(16, cake.getBakingSoda());
        preparedStatement.setDouble(17, cake.getBakingPowder());
        preparedStatement.setDouble(18, cake.getConfectionersSugar());
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
        preparedStatement.setDouble(2, cake.getFlour());
        preparedStatement.setDouble(3, cake.getSugar());
        preparedStatement.setDouble(4, cake.getEggs());
        preparedStatement.setDouble(5, cake.getButter());
        preparedStatement.setDouble(6, cake.getCreamCheese());
        preparedStatement.setDouble(7, cake.getVanillaSugar());
        preparedStatement.setDouble(8, cake.getMilk());
        preparedStatement.setDouble(9, cake.getOil());
        preparedStatement.setDouble(10, cake.getGelatin());
        preparedStatement.setDouble(11, cake.getCornFlour());
        preparedStatement.setDouble(12, cake.getCocoa());
        preparedStatement.setDouble(13, cake.getDarkChocolate());
        preparedStatement.setDouble(14, cake.getWhiteChocolate());
        preparedStatement.setDouble(15, cake.getSalt());
        preparedStatement.setDouble(16, cake.getBakingSoda());
        preparedStatement.setDouble(17, cake.getBakingPowder());
        preparedStatement.setDouble(18, cake.getConfectionersSugar());
        preparedStatement.setString(19, cake.getOther());

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public ArrayList<Cake> viewAllRecipes() throws Exception {
        connection = DBManager.getConnection();
        ArrayList<Cake> cakes = new ArrayList<>();

        String query = "SELECT * FROM cake_tin_20";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Cake cake = new Cake(
                    result.getInt("id"),
                    result.getString("cake_title")
            );
            cakes.add(cake);

        }
        return cakes;

    }

    public void deleteRecipeTin18(String title) throws SQLException {
        String query = "DELETE FROM cake_tin_18 WHERE cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void deleteRecipeTin20(String title) throws SQLException {
        String query = "DELETE FROM cake_tin_20 WHERE cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void deleteRecipeTin22(String title) throws SQLException {
        String query = "DELETE FROM cake_tin_22 WHERE cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public Cake getRecipeByCakeTitleTin20(String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, other FROM cake_tin_20 WHERE cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cakeTitle);

        ResultSet result = preparedStatement.executeQuery();
        Cake cake = null;
        if (result.next()) {
            cake = new Cake(

                    result.getString("cake_title"),
                    result.getDouble("flour"),
                    result.getDouble("sugar"),
                    result.getDouble("eggs_grams"),
                    result.getDouble("butter"),
                    result.getDouble("cream_cheese"),
                    result.getDouble("vanilla_sugar"),
                    result.getDouble("milk"),
                    result.getDouble("oil"),
                    result.getDouble("gelatin"),
                    result.getDouble("corn_flour"),
                    result.getDouble("cocoa"),
                    result.getDouble("dark_chocolate"),
                    result.getDouble("white_chocolate"),
                    result.getDouble("salt"),
                    result.getDouble("baking_soda"),
                    result.getDouble("baking_powder"),
                    result.getDouble("confectioners_sugar"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }

    public Cake getRecipeByCakeTitleTin18(String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, other FROM cake_tin_18 WHERE cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cakeTitle);

        ResultSet result = preparedStatement.executeQuery();
        Cake cake = null;
        if (result.next()) {
            cake = new Cake(

                    result.getString("cake_title"),
                    result.getDouble("flour"),
                    result.getDouble("sugar"),
                    result.getDouble("eggs_grams"),
                    result.getDouble("butter"),
                    result.getDouble("cream_cheese"),
                    result.getDouble("vanilla_sugar"),
                    result.getDouble("milk"),
                    result.getDouble("oil"),
                    result.getDouble("gelatin"),
                    result.getDouble("corn_flour"),
                    result.getDouble("cocoa"),
                    result.getDouble("dark_chocolate"),
                    result.getDouble("white_chocolate"),
                    result.getDouble("salt"),
                    result.getDouble("baking_soda"),
                    result.getDouble("baking_powder"),
                    result.getDouble("confectioners_sugar"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }

    public Cake getRecipeByCakeTitleTin22(String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, other FROM cake_tin_22 WHERE cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cakeTitle);

        ResultSet result = preparedStatement.executeQuery();
        Cake cake = null;
        if (result.next()) {
            cake = new Cake(

                    result.getString("cake_title"),
                    result.getDouble("flour"),
                    result.getDouble("sugar"),
                    result.getDouble("eggs_grams"),
                    result.getDouble("butter"),
                    result.getDouble("cream_cheese"),
                    result.getDouble("vanilla_sugar"),
                    result.getDouble("milk"),
                    result.getDouble("oil"),
                    result.getDouble("gelatin"),
                    result.getDouble("corn_flour"),
                    result.getDouble("cocoa"),
                    result.getDouble("dark_chocolate"),
                    result.getDouble("white_chocolate"),
                    result.getDouble("salt"),
                    result.getDouble("baking_soda"),
                    result.getDouble("baking_powder"),
                    result.getDouble("confectioners_sugar"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }


}
