package top.xiaotian.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.xiaotian.springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@RestController
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String res = paymentHystrixService.paymentInfo_Ok(id);
        return res;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
            })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int age = 1 / 0;
        String res = paymentHystrixService.paymentInfo_TimeOut(id);
        return res;
    }

    public String paymentTimeOutFallBackMethod(Integer id) {
        return "支付系统繁忙，请10秒钟后再次尝试o(╥﹏╥)o";
    }
}
