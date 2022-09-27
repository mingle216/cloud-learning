package com.mmh.gateway.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GatewayService {
    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;

    @Resource private ApplicationEventPublisher publisher;

    public void updateRoutes(List<RouteDefinition> routes) {
        if(CollectionUtils.isEmpty(routes)) {
            log.info("No routes fount");
            return;
        }

        routes.forEach(r -> {
            try {
                routeDefinitionWriter.save(Mono.just(r)).subscribe();
                publisher.publishEvent(new RefreshRoutesEvent(this));
            } catch(Exception e) {
                log.error("cannot update route,id={}",r.getId());
            }
        });
    }
}