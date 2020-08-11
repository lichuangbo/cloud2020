package top.xiaotian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.xiaotian.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 问题：
     * 自测高并发环境下（jmeter大量线程访问timeout方法），即使是第一个方法也会被影响
     * 因为Tomcat的默认工作线程数被打满了，没有多余线程来分解压力和处理
     */

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_OK(id);
        return res;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_TimeOut(id);
        return res;
    }
}
