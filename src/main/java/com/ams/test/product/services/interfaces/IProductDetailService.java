package com.ams.test.product.services.interfaces;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.restcontroller.ProductDetailController;

import java.util.ArrayList;

public interface IProductDetailService {

    ArrayList<ProductDetail> getSimilarProduct(String id);

}
