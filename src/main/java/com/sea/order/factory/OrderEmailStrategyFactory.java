package com.sea.order.factory;
import com.google.common.collect.Maps;
import com.sea.order.annotation.OrderEmailTypeAnnotation;
import com.sea.order.strategy.OrderEmailTypeStrategyInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @description: 发送订单邮件类型策略工厂
 * @author: Sea
 * @time: 2020/06/01 0002 04:26
 */
@Component
public class OrderEmailStrategyFactory {
    private static final Map<String, OrderEmailTypeStrategyInterface> STRATEGY_BEAN_CACHE = Maps.newConcurrentMap();

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * @description: 订单邮件类型策略
     * @param: type
     * @return: OrderEmailTypeStrategyInterface
     * @author: Sea
     * @time: 2020/06/01 0002 04:26
     */
    public OrderEmailTypeStrategyInterface orderEmailStrategy(int type) {
        Optional<OrderEmailTypeStrategyInterface> strategyOptional = STRATEGY_BEAN_CACHE.entrySet()
                .stream()
                .map(e->{
                    OrderEmailTypeAnnotation validType = e.getValue().getClass().getDeclaredAnnotation(OrderEmailTypeAnnotation.class);
                    if (Objects.equals(validType.type(),type)) {
                        return e.getValue();
                    }
                    return null;
                }).filter(Objects::nonNull).findFirst();
        if(strategyOptional.isPresent()){
            return strategyOptional.get();
        }
        throw new RuntimeException("获取策略失败");
    }
    /**
     * 初始化订单邮件类型策略列表
     */
    @PostConstruct
    private void init() {
        STRATEGY_BEAN_CACHE.putAll(applicationContext.getBeansOfType(OrderEmailTypeStrategyInterface.class));
    }

}
