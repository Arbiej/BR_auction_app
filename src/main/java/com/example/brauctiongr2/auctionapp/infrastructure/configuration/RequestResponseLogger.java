package com.example.brauctiongr2.auctionapp.infrastructure.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
class RequestResponseLogger implements ClientHttpRequestInterceptor {
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException{
        traceRequest(httpRequest,body);
        ClientHttpResponse clientHttpResponse=clientHttpRequestExecution.execute(httpRequest,body);
        traceResponse(clientHttpResponse);
        return clientHttpResponse;
    }
    private void traceRequest(HttpRequest httpRequest, byte[] body){
        log.info("==============request start=============");
        log.info("URI          :{}", httpRequest.getURI());
        log.info("Method       :{}", httpRequest.getMethod());
        log.info("Headers      :{}", httpRequest.getHeaders());
        log.info("Request body :{}", new String(body, StandardCharsets.UTF_8));
        log.info("===============request end=========", httpRequest.getURI());
    }
    private void traceResponse(ClientHttpResponse clientHttpResponse) throws IOException{
        log.info("============response start==========");
        log.info("Status code  :{}", clientHttpResponse.getStatusCode());
        log.info("Status text  :{}", clientHttpResponse.getStatusText());
        log.info("Headers      :{}", clientHttpResponse.getHeaders());
        log.info("============response end=========");
    }
}
