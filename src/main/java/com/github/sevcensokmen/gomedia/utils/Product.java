package com.github.sevcensokmen.gomedia.utils;


import java.util.Objects;

public class Product {

    private String name;
    private String price;

    public Product(String name, String price, int productStock) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
