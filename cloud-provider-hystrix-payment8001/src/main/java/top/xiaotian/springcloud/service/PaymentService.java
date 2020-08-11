package top.xiaotian.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }

    /**
     * 支付服务侧服务降级
     * 设置自身调用超时时间的峰值，峰值内可以正常运行；超过了用兜底的方法处理，做服务降级fallback
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int time = 2;
//        int a = 1 / 0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id：" + id + " ，耗时：" + time + "O(∩_∩)O哈哈~";
    }

    public String paymentInfo_timeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 系统繁忙，请稍后再试, id：" + id + "o(╥﹏╥)o";
    }


    //////////////////////
    // 服务的降级  ->  进而熔断  ->  恢复调用链路
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value = "true"),// 开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到多少后熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能为负数");
        }

        String num = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "调用成功， 流水号：" + num;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请重试 o(╥﹏╥)o， id:" + id;
    }
}
