package com.po;

import java.util.Date;

public class Visitor extends Person {
    private String price;
    private Date time;

    @Override
    public String toString() {
        return super.toString() + "  Visitor info is " +
                "price='" + price + '\'' +
                ", time=" + time
                ;
    }

    public Visitor() {
    }

    public Visitor(String name, String age, String sex, String price, Date time) {
        super(name, age, sex);
        this.price = price;
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
