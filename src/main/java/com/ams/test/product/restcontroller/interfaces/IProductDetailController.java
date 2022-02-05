package com.ams.test.product.restcontroller.interfaces;

import com.ams.test.utilsGeneral.Response.Pojo.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RequestMapping("/product")
public interface IProductDetailController {

    @RequestMapping(value = "/{productId}/similar", method = RequestMethod.GET)
    BaseResponse getSimilarProduct(@PathVariable("productId") String productId);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    boolean test();

}
