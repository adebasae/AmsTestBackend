package com.ams.test.utilsGeneral.restUtil;

import com.ams.test.utilsGeneral.propertiesManager.PropertiesManager;
import com.ams.test.utilsGeneral.restUtil.Pojo.WebClientRequest;
import com.ams.test.utilsGeneral.restUtil.Pojo.WebClientResponse;
import com.ams.test.utilsGeneral.restUtil.exception.WebClientException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Properties;


// Se podria llegar a entender como un service pero lo veo más como una clase util de una aplicacion
public class RestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);

    /**
     * M�todo que crea un webClient
     *
     * @param request
     *            La petición
     * @param uri
     *            la url de la llamada sin la base
     * @return WebClientResponse La respuesta de la api externa
     */
    public WebClientResponse createClient(WebClientRequest request,String uri) {
        PropertiesManager pManager = PropertiesManager.getInstance();
        Properties mailProperties = pManager.loadProperties("application");
        WebClient webClient = WebClient.builder()
                .baseUrl(mailProperties.getProperty("webclient_baseurl"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

        WebClientResponse response = webClient.post()
                .uri(uri)
                .body(Mono.just(request), WebClientRequest.class)
                .retrieve()

                // handle status
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    logger.error("Error endpoint with status code {}", clientResponse.statusCode());
                    throw new WebClientException("HTTP Status 500 error");  // throw custom exception
                })
                .bodyToMono(WebClientResponse.class)
                .block();

        return response;
    }

}
