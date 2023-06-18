package com.queryDemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse {
    private String name;
    private String pname;

    int price;

    public OrderResponse() {
   super();

    }
    public OrderResponse(String name, String pname) {
        this.name = name;
        this.pname = pname;

    }
    public OrderResponse(String name, String pname, int price) {
        this.name = name;
        this.pname = pname;
        this.price =price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "name='" + name + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                '}';
    }
}
