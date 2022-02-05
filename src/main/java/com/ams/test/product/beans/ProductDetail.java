package com.ams.test.product.beans;

import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.math.BigDecimal;

// Se anotaria con entity si fuese una tabla de la bd
@Component
public class ProductDetail implements Serializable {

    private String id;
    private String name;
    private BigDecimal price;
    private boolean availability;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
