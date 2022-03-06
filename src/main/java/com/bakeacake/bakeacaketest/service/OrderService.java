package com.bakeacake.bakeacaketest.service;

import com.bakeacake.bakeacaketest.model.Cake;
import com.bakeacake.bakeacaketest.model.Client;
import com.bakeacake.bakeacaketest.model.Order;
import com.bakeacake.bakeacaketest.repository.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderService {
    private Connection connection = DBManager.getConnection();
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
        String query = "SELECT * FROM clients WHERE user_id = ? ORDER BY client_name";
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
    public Client viewClientProfile(int client_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT client_name, phone, address FROM clients WHERE client_id=" + client_id;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        Client client=null;
        if(result.next()){
            client = new Client(
                    result.getString("client_name"),
                    result.getString("phone"),
                    result.getString("address")
            );
        }
        DBManager.close(result, statement, connection);
        if (client == null) throw new Exception("client not found");
        return client;
    }
    public void updateClient(Client client, int client_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "UPDATE clients SET phone=?, address=? WHERE client_id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, client.getPhoneNumber());
        statement.setString(2, client.getAddress());
        statement.setInt(3, client_id);
        statement.execute();
        statement.close();
        connection.close();
    }
    public void addOrder(int user_id, Order order, Cake cake, Client client) throws Exception {
        connection = DBManager.getConnection();
        String query = "INSERT INTO orders (user_id, client_name, client_id, cake_title, cake_tin_size, delivery_date, " +
                "delivery_time, delivery_options, description, status) " +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2, client.getName());
        preparedStatement.setInt(3, client.getId());
        preparedStatement.setString(4, cake.getCakeTitle());
        preparedStatement.setString(5, order.getTinSize());
        preparedStatement.setString(6, order.getDatePicker());
        preparedStatement.setString(7, order.getDeliveryTime());
        preparedStatement.setString(8, order.getDeliveryOptions());
        preparedStatement.setString(9, order.getDescription());
        preparedStatement.setString(10, order.getStatus());

        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }
    public Order viewOrder(int id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE id=" + id;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        Order order=null;
        if(result.next()){
            order = new Order(
                    result.getString("client_name"),
                    result.getString("cake_title"),
                    result.getString("cake_tin_size"),
                    result.getString("delivery_date"),
                    result.getString("delivery_time"),
                    result.getString("delivery_options"),
                    result.getString("description"),
                    result.getString("status")
            );
        }
        DBManager.close(result, statement, connection);
        if (order == null) throw new Exception("order not found");
        return order;
    }
    public void updateOrder(Order order, int id) throws Exception{
        connection = DBManager.getConnection();
        String query = "UPDATE orders SET cake_tin_size=?, delivery_date=?, delivery_time=?, " +
                "delivery_options=?, description=?, status=? WHERE id=" + id;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, order.getTinSize());
        statement.setString(2, order.getDatePicker());
        statement.setString(3, order.getDeliveryTime());
        statement.setString(4, order.getDeliveryOptions());
        statement.setString(5, order.getDescription());
        statement.setString(6, order.getStatus());
        statement.execute();
        statement.close();
        connection.close();
    }

    public ArrayList<Order> viewAllOder(int user_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" ORDER BY delivery_date, delivery_time";
        return getOrders(query);
    }
    public ArrayList<Order> viewAllOderBetweenDate(int user_id, String date, String date1) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND delivery_date BETWEEN ? AND ? ORDER BY delivery_date, delivery_time";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, date1);
        return getOrders(statement);
    }

    private ArrayList<Order> getOrders(PreparedStatement statement) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet result = statement.executeQuery();
        while (result.next()){
            Order order = new Order(
                    result.getInt("id"),
                    result.getString("client_name"),
                    result.getInt("client_id"),
                    result.getString("cake_title"),
                    result.getString("cake_tin_size"),
                    result.getString("delivery_date"),
                    result.getString("delivery_time"),
                    result.getString("delivery_options"),
                    result.getString("description"),
                    result.getString("status")
            );
            orders.add(order);
        }
        DBManager.close(result, statement, connection);
        return orders;
    }

    public ArrayList<Order> viewAllPendingOder(int user_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Pending' ORDER BY delivery_date, delivery_time";
        return getOrders(query);
    }
    public ArrayList<Order> viewPendingOderBetweenDate(int user_id, String date, String date1) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Pending' AND delivery_date BETWEEN ? AND ? ORDER BY delivery_date, delivery_time";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, date1);
        return getOrders(statement);
    }
    public ArrayList<Order> viewAllDeliveredOder(int user_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Delivered' ORDER BY delivery_date, delivery_time";
        return getOrders(query);
    }
    public ArrayList<Order> viewDeliveredOderBetweenDate(int user_id, String date, String date1) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Delivered' AND delivery_date BETWEEN ? AND ? ORDER BY delivery_date, delivery_time";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, date1);
        return getOrders(statement);
    }
    public ArrayList<Order> viewAllCanceledOder(int user_id) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Canceled' ORDER BY delivery_date, delivery_time";
        return getOrders(query);
    }
    public ArrayList<Order> viewCanceledOderBetweenDate(int user_id, String date, String date1) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE user_id=" + user_id +" AND status='Canceled' AND delivery_date BETWEEN ? AND ? ORDER BY delivery_date, delivery_time";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, date1);
        return getOrders(statement);
    }
    private ArrayList<Order> getOrders(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return getOrders(statement);
    }
}
