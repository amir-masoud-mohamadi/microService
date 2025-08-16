package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class TransactionIdFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String transactionId = UUID.randomUUID().toString();

        // افزودن به هدر درخواست
        ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                .header("X-Transaction-ID", transactionId)
                .build();

        // افزودن به هدر پاسخ
        ServerHttpResponse modifiedResponse = exchange.getResponse();
        modifiedResponse.getHeaders().add("X-Transaction-ID", transactionId);

        return chain.filter(
                exchange.mutate().request(modifiedRequest).response(modifiedResponse).build()
        );
    }
}
