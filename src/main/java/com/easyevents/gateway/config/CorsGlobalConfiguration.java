package com.easyevents.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.WebFilter;

@Configuration
public class CorsGlobalConfiguration {

	@Bean
	public WebFilter corsFilter() {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			if (CorsUtils.isCorsRequest(request)) {
				ServerHttpResponse response = exchange.getResponse();
				HttpHeaders headers = response.getHeaders();
				headers.add("Access-Control-Allow-Origin", "http://26.137.230.238:8080");
				headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
				headers.add("Access-Control-Allow-Headers", "http://26.137.230.238:8080");
			}
			return chain.filter(exchange);
		};
	}
}