package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.model.Order;
import com.bakeacake.bakeacaketest.model.User;
import com.bakeacake.bakeacaketest.repository.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private Connection connection = DBManager.getConnection();

    public int verifyUserDetail(String username, String password) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT * FROM users WHERE username = ? && password = md5(?) LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);

        Integer userId = null;
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) userId = resultSet.getInt("id");
        DBManager.close(resultSet, statement, connection);
        if (userId == null || userId == 0) throw new Exception("User name or password not correct");
        return userId;

    }

    public int verifyUserForResetPassword(String username, String email, String secret_question, String answer) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT * FROM users WHERE username = ? AND email = ? AND secret_question = ? AND secret_answer = md5(?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, email);
        statement.setString(3, secret_question);
        statement.setString(4, answer);

        Integer userId = null;
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) userId = resultSet.getInt("id");
        DBManager.close(resultSet, statement, connection);
        if (userId == null || userId == 0)
            throw new Exception("User name, email, secret question or answer not correct");
        return userId;

    }

    public void registerUser(User user) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO users (name, username, password, email,  secret_question, secret_answer) VALUES (?,?,md5(?),?,?,md5(?))";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getSecretQuestion());
        preparedStatement.setString(6, user.getSecretAnswer());


        preparedStatement.execute();
        preparedStatement.close();
    }
//
//
//    public User getUserProfile(int userId) throws Exception {
//        connection = DBManager.getConnection();
//        String query = "SELECT id, name, username, email"
//                + " FROM users WHERE id = ? LIMIT 1";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, userId);
//
//        ResultSet result = preparedStatement.executeQuery();
//        User user = null;
//        if (result.next()) {
//            user = new User(
//                    result.getInt("id"),
//                    result.getString("name"),
//                    result.getString("username"),
//                    result.getString("email"));
//
//        }
//        DBManager.close(result, preparedStatement, connection);
//        if (user == null) throw new Exception("User not found!");
//        return user;
//    }

    public void changePassword(int id, String password) throws Exception {
        connection = DBManager.getConnection();

        String query = "UPDATE users SET password = md5(?) WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, password);
        preparedStatement.setInt(2, id);

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();

    }

    public String findNameById(int userId) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT name FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);


        String name = null;
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) name = resultSet.getString("name");
        DBManager.close(resultSet, statement, connection);
        if (name == null) throw new Exception("No users found with provided id");
        return name;

    }

    public void addClient(int user_id, Client client) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO clients (user_id, client_name, phone, address) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, client.getPhoneNumber());
        preparedStatement.setString(4, client.getAddress());

        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }

    public ArrayList<Client> viewAllClient(int user_id) throws Exception {
        connection = DBManager.getConnection();
        String query = "SELECT * FROM clients WHERE user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);

        ArrayList<Client> clients = new ArrayList<>();
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Client client = new Client(
                    result.getInt("client_id"),
                    result.getString("client_name")
            );
            clients.add(client);
        }
        DBManager.close(result, preparedStatement, connection);
        return clients;
    }

    public void addOrder(int user_id, Order order, Cake cake, Client client) throws Exception {
        connection = DBManager.getConnection();
        String query = "INSERT INTO orders (user_id, client_name, cake_title, cake_tin_size, delivery_date, " +
                "delivery_time, delivery_options, description, status) " +
                "Values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, cake.getCakeTitle());
        preparedStatement.setString(4, order.getTinSize());
        preparedStatement.setString(5, order.getDatePicker());
        preparedStatement.setString(6, order.getDeliveryTime());
        preparedStatement.setString(7, order.getDeliveryOptions());
        preparedStatement.setString(8, order.getDescription());
        preparedStatement.setString(9, order.getStatus());

        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }
}
