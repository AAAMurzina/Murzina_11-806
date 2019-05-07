package com.company.Task02;

public class Phone {
private int price;
private String maker;
private long id;

    public Phone(int price, String maker, long id) {
        this.price = price;
        this.maker = maker;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    public long getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setId(long id) {
        this.id = id;
    }
}


