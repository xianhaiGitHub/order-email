package com.sea.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * OrderDTO 可以非常复杂,可以非常大,比如双十一一个用户可以从不同商家购买，那可以封装成多个小的集合,
 * 笔者所在公司就是非常复杂的一个DTO,但为了方便我就简单做一个DTO~
 * @author sea
 * @date 2020/8/13 21:40
 */
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 5083371865280967214L;
    private String orderId;

    private BigDecimal orderAmount;

    private String itemBrand;

    private String itemName;

    private String itemUrl;

    private String itemImage;

    private BigDecimal itemPrice;

    private String orderAddress;

    private String to;

    private String nickName;
    //币种
    private String currency;



}
