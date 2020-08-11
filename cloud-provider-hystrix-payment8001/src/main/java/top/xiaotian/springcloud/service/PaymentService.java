package top.xiaotian.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
