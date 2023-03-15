package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {

    public static Customer _instance;


    // Create global instance object
    public static Customer getInstance(){
        if (_instance == null) {
            _instance = new Customer();
        }

        return _instance;
    }

    private Integer id;
    private String name, email, deposit;

    /**
     * @param id customer id
     * @param name customer name
     * @param email customer email
     * @param deposit customer deposit
     */
    public Customer(Integer id, String name, String email, String deposit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.deposit = deposit;
    }

    public Customer(){
        this.id = null;
        this.name = null;
        this.email = null;
        this.deposit = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    /**
     * Add customer to customer table in database
     * @param customer customer
     * @return
     */
    public Boolean addCustomer(Customer customer) {

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer (id, name, email, deposit) VALUES (?, ?, ?, ?)");
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getDeposit());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
