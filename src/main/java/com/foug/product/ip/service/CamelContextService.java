package com.foug.product.ip.service;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.spring.boot.SpringBootCamelContext;
import org.apache.camel.support.MessageHelper;
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
                        camelContext.setMessageHistory(true);
            //            camelContext.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void disable(String workerId) {
        try {
            ((SpringBootCamelContext) camelContext).stopRoute(workerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
