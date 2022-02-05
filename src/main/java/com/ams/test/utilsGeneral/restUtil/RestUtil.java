package com.ams.test.utilsGeneral.restUtil;

import com.ams.test.utilsGeneral.restUtil.Pojo.WebClientRequest;
import com.ams.test.utilsGeneral.restUtil.Pojo.WebClientResponse;
import com.ams.test.utilsGeneral.restUtil.exception.WebClientException;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;
import sun.net.www.http.HttpClient;


// Se podria llegar a entender como un service pero lo veo más como una clase util de una aplicacion
public class RestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);


    public WebClientResponse createClient(WebClientRequest request,String uri) {

        // tcp client timeout
        TcpClient tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(3))
                                .addHandlerLast(new WriteTimeoutHandler(3)));

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8899")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))  // timeout
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
