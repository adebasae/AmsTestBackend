package com.ams.test;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.dtos.ProductDetailDto;
import com.ams.test.product.services.interfaces.IProductDetailService;
import com.ams.test.product.services.interfaces.IWebClientProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestApplicationProductSimilarTests {

    @MockBean
    private IWebClientProductService webClientProductService;

    @Autowired
    IProductDetailService productDetailService;

    @Test
    void contextLoads() {
        ArrayList<String>listMock= new ArrayList<>();
        listMock.add("20");
        given(this.webClientProductService.getIdsProductSimilar("10")).willReturn( listMock);
        ProductDetailDto pd = new ProductDetailDto();
        pd.setAvailability(true);
        pd.setId("2");
        pd.setName("Adrian Debasa");
        pd.setPrice(new BigDecimal(20));
        given(this.webClientProductService.getProductDetail("20")).willReturn(pd);

        assertFalse(this.productDetailService.getSimilarProduct("10").isHasError());
        assertTrue(this.productDetailService.getSimilarProduct("100").isHasError());
    }

}
