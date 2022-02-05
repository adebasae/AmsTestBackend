package com.ams.test.product.restcontroller.interfaces;

import com.ams.test.product.beans.ProductDetail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RequestMapping("/product")
public interface IProductDetailController {

    @RequestMapping(value = "/{productId}/similar", method = RequestMethod.GET)
    ArrayList<ProductDetail> getSimilarProduct(@PathVariable("productId") String productId);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    boolean test();

}
