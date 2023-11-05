package com.demo5.entity;

public class Fruit {
    private Integer id;
    private String name;
    private float price;
    private Integer count;
    private String remark;

    public Fruit(Integer id, String name, float price, Integer count, String remark) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.remark = remark;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
