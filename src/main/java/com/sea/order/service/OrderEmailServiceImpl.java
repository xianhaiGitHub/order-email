package com.sea.order.service;

import com.sea.order.common.R;
import com.sea.order.dto.OrderDTO;
import com.sea.order.factory.OrderEmailStrategyFactory;
import com.sea.order.strategy.OrderEmailTypeStrategyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderEmailServiceImpl implements OrderEmailService{

    @Autowired
    OrderEmailStrategyFactory emailTypeStrategyFactory;

    @Override
    public R<Void> sendOrderEmail(int type, OrderDTO orderDTO) {
        OrderEmailTypeStrategyInterface strategy = emailTypeStrategyFactory.orderEmailStrategy(type);
        return  strategy.sendOrderEmailStrategy(type, orderDTO);
    }
}
