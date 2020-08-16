package com.sea.order.service;

import com.sea.order.OrderApplication;
import com.sea.order.dto.OrderDTO;
import javafx.scene.layout.BorderRepeat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes= OrderApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定spring-boot的启动类
public class OrderEmailServiceTest {

    @Resource
    private OrderEmailService orderEmailService;

    @Test
    public void sendOrderEmail() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCurrency("RMB");
        orderDTO.setItemBrand("可口可乐");
        orderDTO.setItemUrl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2435864361,261417072&fm=26&gp=0.jpg");
        orderDTO.setItemImage("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2435864361,261417072&fm=26&gp=0.jpg");
        orderDTO.setItemName("可口可乐100ml");
        orderDTO.setItemPrice(new BigDecimal(2.50000));
        orderDTO.setItemUrl("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%8F%AF%E5%8F%A3%E5%8F%AF%E4%B9%90%E5%9B%BE&hs=2&pn=0&spn=0&di=1540&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3577027695%2C1137157466&os=2186992339%2C3321455270&simid=3295121143%2C231832716&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%8F%AF%E5%8F%A3%E5%8F%AF%E4%B9%90%E5%9B%BE&objurl=http%3A%2F%2Fs10.stb001.cn%2Fftp_product_img%2Fcn1100121026P00_1_xnl.jpg%3Ft%3D20170117&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bfpwrsjf_z%26e3BvgAzdH3Fr6517vpAzdH3F88aa8d8admPaa&gsm=1&islist=&querylist=");
        orderDTO.setNickName("sea");
        orderDTO.setOrderId("202008133434");
        orderDTO.setOrderAddress("广东省深圳市帝王大厦63");
        orderDTO.setTo("2449070915@qq.com");
        orderEmailService.sendOrderEmail(1, orderDTO);
    }
}