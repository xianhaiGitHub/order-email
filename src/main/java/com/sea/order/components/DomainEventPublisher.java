package com.sea.order.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * 发布事件组件
 * @author sea
 * @date 2020/8/13 22:28
 */
@Component
public class DomainEventPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(Object event) {
        applicationContext.publishEvent(event);
    }
}
