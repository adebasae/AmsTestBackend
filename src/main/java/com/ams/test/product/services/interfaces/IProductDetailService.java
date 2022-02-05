package com.ams.test.product.services.interfaces;

import com.ams.test.product.beans.ProductDetail;

import java.util.ArrayList;

public interface IProductDetailService {

    // Pongo Long pues aunque viene un valor pequeño siempre es recomendable poner Long por si sigue creciendo la app
    ArrayList<ProductDetail> getSimilarProduct(Long id);
}
