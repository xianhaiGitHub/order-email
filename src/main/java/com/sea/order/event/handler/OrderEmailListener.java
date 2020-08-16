package com.sea.order.event.handler;

import com.sea.order.event.OrderEmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
/**
 * 监听邮件事件
 * @author sea
 * @date 2020/8/13 22:04
 */
@Component
@Slf4j
public class OrderEmailListener {
    @Resource
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Async("taskExecutor")
    @EventListener
    public void active(OrderEmailEvent event) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(event.getFrom());
            helper.setTo(event.getTo()); // 接收地址
            helper.setSubject(event.getSubject()); // 标题
            Context context = new Context();
            Map<String, Object> map = new HashMap<>(32);
            map.put("order", event.getOrderDTO());
            context.setVariables(map);
            String template = templateEngine.process(event.getOrderEmailTemplate(), context);
            helper.setText(template, true);
            mailSender.send(message);
            log.info("======>>发送订单给:{},模板:{}",event.getTo(),event.getOrderEmailTemplate());
        } catch (Exception e) {
            log.error("发送订单邮件失败:{},订单类型:{},接收用户:{}",e.getMessage(),event.getOrderEmailTemplate(),event.getTo());
        }
    }
}
