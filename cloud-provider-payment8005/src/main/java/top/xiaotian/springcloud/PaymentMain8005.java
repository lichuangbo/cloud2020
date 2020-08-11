package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8005.class, args);
        System.out.println("8005支付服务启动成功---Eureka Client端");
    }
}
