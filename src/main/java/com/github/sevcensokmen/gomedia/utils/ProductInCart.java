package com.github.sevcensokmen.gomedia.utils;

public class ProductInCart {

    private String name;
    private double quantity;
    private int perUnit;
    private double  total;

    public ProductInCart(String name, double quantity, int perUnit, double total) {
        this.name = name;
        this.quantity = quantity;
        this.perUnit = perUnit;
        this.total = total;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(int perUnit) {
        this.perUnit = perUnit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
