package com.ams.test.product.services;

import com.ams.test.product.beans.ProductDetail;
import com.ams.test.product.dtos.ProductDetailDto;
import com.ams.test.product.services.interfaces.IWebClientProductService;
import com.ams.test.utilsGeneral.Constants;
import com.ams.test.utilsGeneral.restUtil.WebClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;


@Service
public class WebClientProductService implements IWebClientProductService {

    private static final Logger logger = LoggerFactory.getLogger(WebClientProductService.class);
    private final String BASE_URL_PROPERTY="webclient_baseurl_product";
    private  WebClient wc = WebClientUtil.createClient(Constants.APPLICATION_PROPERTY,BASE_URL_PROPERTY);

    /**
     * Método que crea un webClient para buscar los productos similares a un id de producto
     *
     * @param idProduct
     *            id del producto para buscar similares
     * @return Lista de id de productos
     */
    @Override
    public ArrayList<String> getIdsProductSimilar(  String idProduct) {
        logger.info("Iniciando Class: WebClientProductService; Method: getIdsProductSimilar");
        // Se que puede ir el return aqui pero para que se entienda mejor en este caso lo hice asi
        ArrayList<String> ids = wc.get().uri("/{id}/similarids", idProduct)
                .retrieve().bodyToMono(new ParameterizedTypeReference<ArrayList<String>>() {}).onErrorResume(WebClientResponseException.class,
                ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex)).block();
        logger.info("Recuperado ids");
        return  ids;

    }

    /**
     * Método que crea un webClient para buscar los detalles de un producto dado un id
     *
     * @param idProduct
     *            id del producto para buscar sus detalles
     * @return Detalles del producto
     */
    @Override
    public ProductDetailDto getProductDetail(String idProduct) {
        logger.info("Iniciando Class: WebClientProductService; Method: getProductDetail");
        // Se que puede ir el return aqui pero para que se entienda mejor en este caso lo hice asi
        ProductDetailDto productDetail = wc.get().uri("/{id}", idProduct)
                .retrieve().bodyToMono(new ParameterizedTypeReference<ProductDetailDto>() {}).onErrorResume(WebClientResponseException.class,
                ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex)).block();
        logger.info("Recuperado detalles");
        return  productDetail;
    }

}
