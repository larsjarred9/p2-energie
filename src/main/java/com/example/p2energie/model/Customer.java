package com.example.p2energie.model;

public class Customer {

    public static Gas _instance;

    public static Gas getInstance(){
        if (_instance == null) {
            _instance = new Gas();
        }

        return _instance;
    }

    private String id, name, email, deposit;

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

    public Customer(){
        this.id = null;
        this.name = null;
        this.email = null;
        this.deposit = null;
    }

    public static void set_instance(Gas _instance) {
        Customer._instance = _instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
