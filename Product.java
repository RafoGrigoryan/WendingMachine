package com.company.day1;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;

    public Product(String prod) {
        name=prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
