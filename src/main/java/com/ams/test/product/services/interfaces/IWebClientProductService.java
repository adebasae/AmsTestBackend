package com.ams.test.product.services.interfaces;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.dtos.WebClientProductDto;

import java.util.ArrayList;

public interface IWebClientProductService {

    ArrayList<Long> getIdsProductSimilar(  Long idProduct);

    ArrayList<ProductDetail> getProductDetail( Long idProduct);

}
