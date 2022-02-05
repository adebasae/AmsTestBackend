package com.ams.test.product.utils;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.utilsGeneral.Response.Pojo.BasePojo;

import java.util.ArrayList;

public class ProductPojoResponse extends BasePojo {

    private ArrayList<ProductDetail> productDetails;

    public ArrayList<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ArrayList<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }
}
