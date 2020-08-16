package com.sea.order.event;

import com.sea.order.dto.OrderDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
/**
 *
 * 订单事件类
 * @author sea
 * @date 2020/8/13 21:52
 */
@Getter
public class OrderEmailEvent extends ApplicationEvent {
    private String to;

    private String from;

    private String subject;

    private String orderEmailTemplate;

    private OrderDTO orderDTO;

    public OrderEmailEvent(Object source, String to, String from, String subject, String orderEmailTemplate, OrderDTO orderDTO) {
        super(source);
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.orderEmailTemplate = orderEmailTemplate;
        this.orderDTO = orderDTO;
    }
}
