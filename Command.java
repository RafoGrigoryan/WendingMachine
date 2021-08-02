package com.company.day1;

public class Command {
    private int coll;
    private String productType;
    private int quantity;
    private  String command;

    public Command(String command) {
        this.command = command;
    }

    public void splint(){
        String[] split = command.split(":");
        productType = split[0];
        coll = Integer.parseInt(split[1]);
        quantity = Integer.parseInt(split[2]);
    }

    public int getColl() {
        return coll;
    }

    public void setColl(int coll) {
        this.coll = coll;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
