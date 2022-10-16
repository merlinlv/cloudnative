package com.me.cloudnative.config;

import com.me.cloudnative.component.RouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class ReactiveConfig {
    @Bean
    RouterFunction<ServerResponse> routerFunction(RouterHandlers routerHandlers) {
       return  RouterFunctions.route(
               RequestPredicates.GET("/mem/all"), routerHandlers::getAll)
               .andRoute(RequestPredicates.GET("/mem/{id}"),routerHandlers::getById)
               .andRoute(RequestPredicates.POST("/mem/add").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),routerHandlers::addMem)
               .andRoute(RequestPredicates.GET("/mem/{id}/event").and(RequestPredicates.accept(MediaType.TEXT_EVENT_STREAM)),routerHandlers::getEvent);
    }
}
