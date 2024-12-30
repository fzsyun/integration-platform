package com.foug.product.ip.service;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.Resource;
import org.apache.camel.support.PluginHelper;
import org.apache.camel.support.ResourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 冯知帅
 * @since 2024/12/27 17:40
 */
@Service
public class CamelContextService {

    @Autowired
    private CamelContext camelContext;

    public void enable(String workerId, String context) {
        Resource resource = ResourceHelper.fromString("test.yaml", context);
        try {
            PluginHelper.getRoutesLoader(camelContext).loadRoutes(resource);
            camelContext.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void disable(String workerId) {
        Route route = camelContext.getRoute(workerId);
        route.getCamelContext().stop();
    }
}
