package com.ams.test.product.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductDetailDto  {

    // Pongo String porque asi lo pone el contrato
    @JsonProperty
    private  String id ;
    @JsonProperty
    private String name;
    @JsonProperty
    private BigDecimal price;
    @JsonProperty
    private boolean availability;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
