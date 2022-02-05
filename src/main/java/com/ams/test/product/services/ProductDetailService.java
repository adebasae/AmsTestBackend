package com.ams.test.product.services;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.dtos.WebClientProductDto;
import com.ams.test.product.restcontroller.ProductDetailController;
import com.ams.test.product.services.interfaces.IProductDetailService;
import com.ams.test.product.services.interfaces.IWebClientProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductDetailService  implements IProductDetailService {

    private static final Logger logger = LoggerFactory.getLogger(ProductDetailController.class);

    @Autowired
    IWebClientProductService webClientProductService;

    @Override
    public ArrayList<ProductDetail> getSimilarProduct(Long id) {
        logger.info("Iniciando Class: ProductDetailService; Method: getSimilarProduct");
        ArrayList<Long> idsSimiliars =  webClientProductService.getIdsProductSimilar( id);
        for (Long idProduct:idsSimiliars) {
            webClientProductService.getProductDetail(idProduct);
        }
        logger.info("Terminó Class: ProductDetailService; Method: getSimilarProduct");
        return null;
    }
}
