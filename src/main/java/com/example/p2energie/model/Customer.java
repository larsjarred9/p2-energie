package com.example.p2energie.model;

public class Customer {
    private final String id, name, email, deposit;

    /**
     * @param id customer id
     * @param name customer name
     * @param email customer email
     * @param deposit customer deposit
     */
    public Customer(String id, String name, String email, String deposit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.deposit = deposit;
    }
}
