package com.ams.test.product.services;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.services.interfaces.IProductDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductDetailService  implements IProductDetailService {


    @Override
    public ArrayList<ProductDetail> getSimilarProduct(Long id) {
        return null;
    }
}
