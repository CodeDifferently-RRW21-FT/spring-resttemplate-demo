package com.codedifferently.isithot.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("X-RapidAPI-Host", "google-translate1.p.rapidapi.com");
        request.getHeaders().set("X-RapidAPI-Key", "7cc961cb7cmsh51f23a4603eb1f4p1dec01jsn726094c92c31");
        return execution.execute(request,body);
    }
}
