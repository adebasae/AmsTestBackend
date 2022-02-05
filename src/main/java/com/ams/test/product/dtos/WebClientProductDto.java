package com.ams.test.product.dtos;

import java.io.Serializable;
import java.util.ArrayList;

public class WebClientProductDto implements Serializable {

    private ArrayList<Long>idsProduct= new ArrayList<>();

    public ArrayList<Long> getIdsProduct() {
        return idsProduct;
    }

    public void setIdsProduct(ArrayList<Long> idsProduct) {
        this.idsProduct = idsProduct;
    }
}
