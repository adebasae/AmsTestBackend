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

public class WebClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(WebClient.class);

    /**
     * M�todo que crea un webClient
     *
     * @param properties
     *            Nombre del archivo de propiedades
     * @param property
     *            Nombre de la Propiedad dentro del archivo de propiedades
     * @return WebClientResponse La respuesta de la api externa
     */
    public static WebClient createClient( String properties,String property) {
        PropertiesManager pManager = PropertiesManager.getInstance();
        Properties mailProperties = pManager.loadProperties(properties);
        WebClient webClient = org.springframework.web.reactive.function.client.WebClient.builder()
                .baseUrl(mailProperties.getProperty(property))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();


        return webClient;
    }

}
