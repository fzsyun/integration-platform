package com.foug.product.ip;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.spi.CamelEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyCollector extends EventNotifierSupport {

    @Override
    public void notify(CamelEvent event) throws Exception {
        //        CamelEvent.StepEvent stepEvent = (CamelEvent.StepEvent) event;
        //
        //        // Get detailed information from the StepEvent
        //        String eventType = stepEvent.getType().name();
        //        String stepId = stepEvent.getStepId();
        //        String body = stepEvent.getExchange().getMessage().getBody(String.class);
        //
        //        log.info("Event Type:\t\t" + eventType);
        //        log.info("Step ID:\t\t\t" + stepId);
        //        log.info("Message Body:\t\t " + body);z

        //        log.info("Event Type:\t\t" + event.getType().name());

        if (event instanceof CamelEvent.ExchangeCompletedEvent exchangeCompletedEvent) {
            //            log.info("Exchange ID:\t\t\t" + exchangeCompletedEvent.getExchange().getExchangeId());
            log.info("Message ID:\t\t\t" + exchangeCompletedEvent.getExchange().getMessage().getMessageId());
            //            log.info("Message Body:\t\t " + exchangeCompletedEvent.getExchange().getMessage().getBody(String.class));
            log.info("变量：{}", exchangeCompletedEvent.getExchange().getVariables());
        }

    }

}