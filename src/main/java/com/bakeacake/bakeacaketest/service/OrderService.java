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
    public void addClient(Client client) throws SQLException {
        connection = DBManager.getConnection();
        String query = "INSERT INTO clients (client_name, phone, address) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getPhoneNumber());
        preparedStatement.setString(3, client.getAddress());

        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }
    public ArrayList<Client> viewAllClient() throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM clients ORDER BY client_name";
        PreparedStatement statement = connection.prepareStatement(query);
        ArrayList<Client> clients = new ArrayList<>();
        ResultSet result = statement.executeQuery();

        while (result.next()){
            Client client = new Client(
                    result.getInt("client_id"),
                    result.getString("client_name")
            );
            clients.add(client);
        }
        DBManager.close(result, statement, connection);
        return clients;
    }
    public void addOrder(Order order, Cake cake, Client client) throws Exception{
        connection = DBManager.getConnection();
        String query = "INSERT INTO orders (client_name, client_id, cake_title, cake_tin_size, delivery_date, " +
                "delivery_time, delivery_options, description, status) " +
                "Values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setInt(2, client.getId());
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
    public ArrayList<Order> viewAllOder() throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders ORDER BY delivery_date";
        return getOrders(query);
    }
    public ArrayList<Order> viewAllOderBetweenDate(String date, String date1) throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE delivery_date BETWEEN " + date + " AND " + date1+
                " ORDER BY delivery_date";
        return getOrders(query);
    }
    public ArrayList<Order> viewAllPendingOder() throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE status='Pending' ORDER BY delivery_date";
        return getOrders(query);
    }
    public ArrayList<Order> viewAllDeliveredOder() throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE status='Delivered' ORDER BY delivery_date";
        return getOrders(query);
    }
    public ArrayList<Order> viewAllCanceledOder() throws Exception{
        connection = DBManager.getConnection();
        String query = "SELECT * FROM orders WHERE status='Canceled' ORDER BY delivery_date";
        return getOrders(query);
    }

    private ArrayList<Order> getOrders(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet result = statement.executeQuery();
        while (result.next()){
            Order order = new Order(
                    result.getString("client_name"),
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
}
