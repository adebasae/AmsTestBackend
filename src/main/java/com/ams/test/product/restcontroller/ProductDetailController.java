package com.ams.test.product.restcontroller;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.restcontroller.interfaces.IProductDetailController;
import com.ams.test.product.services.interfaces.IProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
public class ProductDetailController implements IProductDetailController {

    @Autowired
    IProductDetailService productDetailService;
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailController.class);


    @Override
    public ArrayList<ProductDetail> getSimilarProduct(Long productId) {
        logger.info("Comenzando getSimilarProduct en ProductDetailController ");
        return productDetailService.getSimilarProduct(productId );
    }

    @Override
    public boolean test() {
            return true;
    }
}
