package com.ams.test.product.services.interfaces;

import com.ams.test.product.dtos.ProductDetailDto;

import java.util.ArrayList;

public interface IWebClientProductService {

    ArrayList<String> getIdsProductSimilar(  String idProduct);

    ProductDetailDto getProductDetail(String idProduct);

}
