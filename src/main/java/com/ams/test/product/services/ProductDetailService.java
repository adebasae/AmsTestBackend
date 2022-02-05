package com.ams.test.product.services;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.dtos.ProductDetailDto;
import com.ams.test.product.exception.ProductException;
import com.ams.test.product.restcontroller.ProductDetailController;
import com.ams.test.product.services.interfaces.IProductDetailService;
import com.ams.test.product.services.interfaces.IWebClientProductService;
import com.ams.test.product.utils.ProductPojoResponse;
import com.ams.test.utilsGeneral.Constants;
import com.ams.test.utilsGeneral.Response.Pojo.BaseResponse;
import org.modelmapper.ModelMapper;
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
    public BaseResponse getSimilarProduct(String id) {

        BaseResponse br =  new BaseResponse();
        br.setHasError(false);
        br.setDescription(Constants.OK);
        try{
            logger.info("Iniciando Class: ProductDetailService; Method: getSimilarProduct");
            ModelMapper mm = new ModelMapper();
            ArrayList<ProductDetail> productDetails =  new ArrayList<>();
            ArrayList<String> idsSimiliars =  webClientProductService.getIdsProductSimilar( id);
            if(idsSimiliars==null || idsSimiliars.size()==0){
                throw new ProductException("Product not found");
            }
            for (String idProduct:idsSimiliars) {
                ProductDetailDto productDetailDto = webClientProductService.getProductDetail(idProduct);
                ProductDetail productDetail= mm.map(productDetailDto,ProductDetail.class);
                productDetails.add(productDetail);
            }
            logger.info("Terminó Class: ProductDetailService; Method: getSimilarProduct");
            ProductPojoResponse pojoResponse = new ProductPojoResponse();
            pojoResponse.setProductDetails(productDetails);
            br.setPojo(pojoResponse);
        }
        catch (ProductException e){
            br.setDescription(Constants.KO + "-> " + e.getMessage());
            br.setHasError(true);
        }
        catch (Exception e){
            br.setDescription(Constants.KO + "-> " + e.getMessage());
            br.setHasError(true);
        }

        return br;
    }
}
