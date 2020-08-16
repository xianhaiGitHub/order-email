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
@OrderEmailTypeAnnotation(type = SystemConstant.ORDER_SUMMARY)
public class PlaceOrderEmailStrategy implements OrderEmailTypeStrategyInterface {
    @Value("${spring.mail.username}")
    private String from;

    private static final String PLACE_ORDER= "placeOrder";

    @Autowired
    DomainEventPublisher domainEventPublisher;

    @Override
    public R<Void> sendOrderEmailStrategy(int type, OrderDTO orderDTO) {
        String subject = "您的訂單 " + orderDTO.getOrderId() + " 正在处理中~";
        log.info("============>>用户下单发送邮件 type:{},orderDTO:{}",type, JSON.toJSONString(orderDTO));
        domainEventPublisher.publishEvent(new OrderEmailEvent(this,
                orderDTO.getTo(),
                from,
                subject,
                PLACE_ORDER,
                orderDTO
        ));
        return R.ok();
    }
}

