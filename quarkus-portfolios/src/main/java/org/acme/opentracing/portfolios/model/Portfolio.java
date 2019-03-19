package org.acme.opentracing.portfolios.model;

public class Portfolio {
    private String code;
    private int amount;
    private User manager;

    public Portfolio() {
    }


    public Portfolio(String code, int amount) {
        this.code = code;
        this.amount = amount;
    }

    public Portfolio(String code, int amount, User manager) {
        this.code = code;
        this.amount = amount;
        this.manager = manager;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
