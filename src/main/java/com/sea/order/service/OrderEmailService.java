package com.sea.order.service;

import com.sea.order.common.R;
import com.sea.order.dto.OrderDTO;

/**
 *
 * 发送邮件服务
 * @author sea
 * @date 2020/8/13 22:19
 */
public interface OrderEmailService {

    /**
     *
     * 发送订单邮件(下单1、缺货2、取消订单3)
     * @author sea
     * @date 2020/8/13 22:21
     * @param [type, orderDTO]
     * @return com.sea.order.common.R<java.lang.Void>
     */
    R<Void> sendOrderEmail(int type, OrderDTO orderDTO);
}
