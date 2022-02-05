package com.ams.test.product.services.interfaces;

import com.ams.test.utilsGeneral.Response.Pojo.BaseResponse;


public interface IProductDetailService {

    BaseResponse getSimilarProduct(String id);

}
