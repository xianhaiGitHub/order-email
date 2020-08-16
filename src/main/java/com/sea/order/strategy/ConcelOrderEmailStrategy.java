package com.sea.order.strategy;

import com.alibaba.fastjson.JSON;
import com.sea.order.annotation.OrderEmailTypeAnnotation;
import com.sea.order.common.R;
import com.sea.order.common.SystemConstant;
import com.sea.order.components.DomainEventPublisher;
import com.sea.order.dto.OrderDTO;
import com.sea.order.event.OrderEmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@OrderEmailTypeAnnotation(type = SystemConstant.CANCELLATION)
public class ConcelOrderEmailStrategy implements OrderEmailTypeStrategyInterface {
    @Value("${spring.mail.username}")
    private String from;

    private static final String CANCEL_ORDER= "cancelOrder";

    @Autowired
    DomainEventPublisher domainEventPublisher;

    @Override
    public R<Void> sendOrderEmailStrategy(int type, OrderDTO orderDTO) {
        String subject = "很抱歉!您的訂單 " + orderDTO.getOrderId() + " 已被取消~";
        log.info("============>>用户取消订单发送邮件 type:{},orderDTO:{}",type, JSON.toJSONString(orderDTO));
        domainEventPublisher.publishEvent(new OrderEmailEvent(this,
                orderDTO.getTo(),
                from,
                subject,
                CANCEL_ORDER,
                orderDTO
        ));
        return R.ok();
    }
}

