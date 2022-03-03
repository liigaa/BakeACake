package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.ShoppingList;
import com.bakeacake.bakeacaketest.repository.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CakeRecipeService {

    private Connection connection = DBManager.getConnection();

    public void addCakeTin20(int user_id, Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_20 (user_id, cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cake.getCakeTitle());
        preparedStatement.setDouble(3, cake.getFlour());
        preparedStatement.setDouble(4, cake.getSugar());
        preparedStatement.setDouble(5, cake.getEggs());
        preparedStatement.setDouble(6, cake.getButter());
        preparedStatement.setDouble(7, cake.getCreamCheese());
        preparedStatement.setDouble(8, cake.getVanillaSugar());
        preparedStatement.setDouble(9, cake.getMilk());
        preparedStatement.setDouble(10, cake.getOil());
        preparedStatement.setDouble(11, cake.getGelatin());
        preparedStatement.setDouble(12, cake.getCornFlour());
        preparedStatement.setDouble(13, cake.getCocoa());
        preparedStatement.setDouble(14, cake.getDarkChocolate());
        preparedStatement.setDouble(15, cake.getWhiteChocolate());
        preparedStatement.setDouble(16, cake.getSalt());
        preparedStatement.setDouble(17, cake.getBakingSoda());
        preparedStatement.setDouble(18, cake.getBakingPowder());
        preparedStatement.setDouble(19, cake.getConfectionersSugar());
        preparedStatement.setDouble(20, cake.getSourCream());
        preparedStatement.setString(21, cake.getOther());


        DBManager.executeAndClose(preparedStatement, connection);
}

    public void addCakeTin18(int user_id, Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_18 (user_id, cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cake.getCakeTitle());
        preparedStatement.setDouble(3, cake.getFlour());
        preparedStatement.setDouble(4, cake.getSugar());
        preparedStatement.setDouble(5, cake.getEggs());
        preparedStatement.setDouble(6, cake.getButter());
        preparedStatement.setDouble(7, cake.getCreamCheese());
        preparedStatement.setDouble(8, cake.getVanillaSugar());
        preparedStatement.setDouble(9, cake.getMilk());
        preparedStatement.setDouble(10, cake.getOil());
        preparedStatement.setDouble(11, cake.getGelatin());
        preparedStatement.setDouble(12, cake.getCornFlour());
        preparedStatement.setDouble(13, cake.getCocoa());
        preparedStatement.setDouble(14, cake.getDarkChocolate());
        preparedStatement.setDouble(15, cake.getWhiteChocolate());
        preparedStatement.setDouble(16, cake.getSalt());
        preparedStatement.setDouble(17, cake.getBakingSoda());
        preparedStatement.setDouble(18, cake.getBakingPowder());
        preparedStatement.setDouble(19, cake.getConfectionersSugar());
        preparedStatement.setDouble(20, cake.getSourCream());
        preparedStatement.setString(21, cake.getOther());


        DBManager.executeAndClose(preparedStatement, connection);
    }

    public void addCakeTin22(int user_id, Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO cake_tin_22 (user_id, cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cake.getCakeTitle());
        preparedStatement.setDouble(3, cake.getFlour());
        preparedStatement.setDouble(4, cake.getSugar());
        preparedStatement.setDouble(5, cake.getEggs());
        preparedStatement.setDouble(6, cake.getButter());
        preparedStatement.setDouble(7, cake.getCreamCheese());
        preparedStatement.setDouble(8, cake.getVanillaSugar());
        preparedStatement.setDouble(9, cake.getMilk());
        preparedStatement.setDouble(10, cake.getOil());
        preparedStatement.setDouble(11, cake.getGelatin());
        preparedStatement.setDouble(12, cake.getCornFlour());
        preparedStatement.setDouble(13, cake.getCocoa());
        preparedStatement.setDouble(14, cake.getDarkChocolate());
        preparedStatement.setDouble(15, cake.getWhiteChocolate());
        preparedStatement.setDouble(16, cake.getSalt());
        preparedStatement.setDouble(17, cake.getBakingSoda());
        preparedStatement.setDouble(18, cake.getBakingPowder());
        preparedStatement.setDouble(19, cake.getConfectionersSugar());
        preparedStatement.setDouble(20, cake.getSourCream());
        preparedStatement.setString(21, cake.getOther());


        DBManager.executeAndClose(preparedStatement, connection);
    }

    public ArrayList<Cake> viewAllRecipes(int user_id) throws Exception {
        connection = DBManager.getConnection();
        ArrayList<Cake> cakes = new ArrayList<>();

        String query = "SELECT * FROM cake_tin_20 WHERE user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);


        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Cake cake = new Cake(
                    result.getInt("id"),
                    result.getString("cake_title")
            );
            cakes.add(cake);

        }
        DBManager.close(result, preparedStatement, connection);
        return cakes;

    }

    public void deleteRecipeTin18(int user_id, String title) throws SQLException {
        connection = DBManager.getConnection();
        String query = "DELETE FROM cake_tin_18 WHERE user_id = ? AND cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, title);

        DBManager.executeAndClose(preparedStatement, connection);

    }

    public void deleteRecipeTin20(int user_id, String title) throws SQLException {
        connection = DBManager.getConnection();
        String query = "DELETE FROM cake_tin_20 WHERE user_id = ? AND cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, title);

        DBManager.executeAndClose(preparedStatement, connection);

    }

    public void deleteRecipeTin22(int user_id, String title) throws SQLException {
        connection = DBManager.getConnection();
        String query = "DELETE FROM cake_tin_22 WHERE user_id = ? AND cake_title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, title);

        DBManager.executeAndClose(preparedStatement, connection);

    }

    public Cake getRecipeByCakeTitleTin20(int user_id, String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other FROM cake_tin_20 WHERE user_id = ? AND cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cakeTitle);

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
                    result.getDouble("sour_cream"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }

    public Cake getRecipeByCakeTitleTin18(int user_id, String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other FROM cake_tin_18 WHERE user_id = ? AND cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cakeTitle);


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
                    result.getDouble("sour_cream"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }

    public Cake getRecipeByCakeTitleTin22(int user_id, String cakeTitle) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT cake_title, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                "salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other FROM cake_tin_22 WHERE user_id = ? AND cake_title = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, cakeTitle);


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
                    result.getDouble("sour_cream"),
                    result.getString("other"));
        }
        DBManager.close(result, preparedStatement, connection);
        if (cake == null) throw new Exception("Recipe not found!");
        return cake;
    }

    public void addToShoppingList(int user_id, Cake cake) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO shopping_list (user_id, flour, sugar, eggs_grams, butter, cream_cheese," +
                "vanilla_sugar, milk, oil, gelatin, corn_flour, cocoa, dark_chocolate, white_chocolate," +
                " salt, baking_soda, baking_powder, confectioners_sugar, sour_cream, other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        preparedStatement.setInt(1, user_id);
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
        preparedStatement.setDouble(19, cake.getSourCream());
        preparedStatement.setString(20, cake.getOther());


        DBManager.executeAndClose(preparedStatement, connection);
    }


    public void updateRecipeTinSize18 (int user_id, Cake cake, String cakeTitle) throws SQLException {
        connection = DBManager.getConnection();
        String query = "UPDATE cake_tin_18 SET flour = ?, sugar = ?, eggs_grams = ?, butter = ?, cream_cheese = ?," +
                "vanilla_sugar = ?, milk = ?, oil = ?, gelatin = ?, corn_flour = ?, cocoa = ?, dark_chocolate = ?, white_chocolate = ?," +
                "salt = ?, baking_soda = ?, baking_powder = ?, confectioners_sugar = ?, sour_cream = ?, other = ? WHERE user_id = ? AND cake_title = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1, cake.getFlour());
        preparedStatement.setDouble(2, cake.getSugar());
        preparedStatement.setDouble(3, cake.getEggs());
        preparedStatement.setDouble(4, cake.getButter());
        preparedStatement.setDouble(5, cake.getCreamCheese());
        preparedStatement.setDouble(6, cake.getVanillaSugar());
        preparedStatement.setDouble(7, cake.getMilk());
        preparedStatement.setDouble(8, cake.getOil());
        preparedStatement.setDouble(9, cake.getGelatin());
        preparedStatement.setDouble(10, cake.getCornFlour());
        preparedStatement.setDouble(11, cake.getCocoa());
        preparedStatement.setDouble(12, cake.getDarkChocolate());
        preparedStatement.setDouble(13, cake.getWhiteChocolate());
        preparedStatement.setDouble(14, cake.getSalt());
        preparedStatement.setDouble(15, cake.getBakingSoda());
        preparedStatement.setDouble(16, cake.getBakingPowder());
        preparedStatement.setDouble(17, cake.getConfectionersSugar());
        preparedStatement.setDouble(18, cake.getSourCream());
        preparedStatement.setString(19, cake.getOther());
        preparedStatement.setInt(20, user_id);
        preparedStatement.setString(21, cake.getCakeTitle());


        DBManager.executeAndClose(preparedStatement, connection);
    }


    public void updateRecipeTinSize20 (int user_id, Cake cake, String cakeTitle) throws SQLException {
        connection = DBManager.getConnection();
        String query = "UPDATE cake_tin_20 SET flour = ?, sugar = ?, eggs_grams = ?, butter = ?, cream_cheese = ?," +
                "vanilla_sugar = ?, milk = ?, oil = ?, gelatin = ?, corn_flour = ?, cocoa = ?, dark_chocolate = ?, white_chocolate = ?," +
                "salt = ?, baking_soda = ?, baking_powder = ?, confectioners_sugar = ?, sour_cream = ?, other = ? WHERE user_id = ? AND cake_title = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1, cake.getFlour());
        preparedStatement.setDouble(2, cake.getSugar());
        preparedStatement.setDouble(3, cake.getEggs());
        preparedStatement.setDouble(4, cake.getButter());
        preparedStatement.setDouble(5, cake.getCreamCheese());
        preparedStatement.setDouble(6, cake.getVanillaSugar());
        preparedStatement.setDouble(7, cake.getMilk());
        preparedStatement.setDouble(8, cake.getOil());
        preparedStatement.setDouble(9, cake.getGelatin());
        preparedStatement.setDouble(10, cake.getCornFlour());
        preparedStatement.setDouble(11, cake.getCocoa());
        preparedStatement.setDouble(12, cake.getDarkChocolate());
        preparedStatement.setDouble(13, cake.getWhiteChocolate());
        preparedStatement.setDouble(14, cake.getSalt());
        preparedStatement.setDouble(15, cake.getBakingSoda());
        preparedStatement.setDouble(16, cake.getBakingPowder());
        preparedStatement.setDouble(17, cake.getConfectionersSugar());
        preparedStatement.setDouble(18, cake.getSourCream());
        preparedStatement.setString(19, cake.getOther());
        preparedStatement.setInt(20, user_id);
        preparedStatement.setString(21, cake.getCakeTitle());


        DBManager.executeAndClose(preparedStatement, connection);
    }

    public void updateRecipeTinSize22 (int user_id, Cake cake, String cakeTitle) throws SQLException {
        connection = DBManager.getConnection();
        String query = "UPDATE cake_tin_22 SET flour = ?, sugar = ?, eggs_grams = ?, butter = ?, cream_cheese = ?," +
                "vanilla_sugar = ?, milk = ?, oil = ?, gelatin = ?, corn_flour = ?, cocoa = ?, dark_chocolate = ?, white_chocolate = ?," +
                "salt = ?, baking_soda = ?, baking_powder = ?, confectioners_sugar = ?, sour_cream = ?, other = ? WHERE user_id = ? AND cake_title = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1, cake.getFlour());
        preparedStatement.setDouble(2, cake.getSugar());
        preparedStatement.setDouble(3, cake.getEggs());
        preparedStatement.setDouble(4, cake.getButter());
        preparedStatement.setDouble(5, cake.getCreamCheese());
        preparedStatement.setDouble(6, cake.getVanillaSugar());
        preparedStatement.setDouble(7, cake.getMilk());
        preparedStatement.setDouble(8, cake.getOil());
        preparedStatement.setDouble(9, cake.getGelatin());
        preparedStatement.setDouble(10, cake.getCornFlour());
        preparedStatement.setDouble(11, cake.getCocoa());
        preparedStatement.setDouble(12, cake.getDarkChocolate());
        preparedStatement.setDouble(13, cake.getWhiteChocolate());
        preparedStatement.setDouble(14, cake.getSalt());
        preparedStatement.setDouble(15, cake.getBakingSoda());
        preparedStatement.setDouble(16, cake.getBakingPowder());
        preparedStatement.setDouble(17, cake.getConfectionersSugar());
        preparedStatement.setDouble(18, cake.getSourCream());
        preparedStatement.setString(19, cake.getOther());
        preparedStatement.setInt(20, user_id);
        preparedStatement.setString(21, cake.getCakeTitle());

        DBManager.executeAndClose(preparedStatement, connection);
    }



}
