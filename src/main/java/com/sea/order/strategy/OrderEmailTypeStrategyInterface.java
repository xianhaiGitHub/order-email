package com.sea.order.strategy;


import com.sea.order.common.R;
import com.sea.order.dto.OrderDTO;

/**
 * @description: 发送订单邮件策略(下单，取消订单,缺货)
 * @author: sea
 * @time: 2020/5/2 0002 20:54
 */
public interface OrderEmailTypeStrategyInterface {

    /**
     *
     * 发送订单邮件共同抽象
     * @author sea
     * @date 2020/8/13 21:40
     * @param [type, orderDTO]
     * @return com.sea.order.common.R<java.lang.Void>
     */
    R<Void> sendOrderEmailStrategy(int type, OrderDTO orderDTO);
}
