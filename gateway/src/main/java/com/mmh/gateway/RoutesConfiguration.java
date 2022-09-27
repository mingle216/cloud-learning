package com.mmh.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator declare(RouteLocatorBuilder builder) {
        return builder.routes().route("id-001", route -> route.path("/user/**")
                        .and().method(HttpMethod.GET).uri("http://localhost:8081"))
                .route(route -> route.path("/share/**")
                        .uri("http://localhost:8082")).build();
    }
}
