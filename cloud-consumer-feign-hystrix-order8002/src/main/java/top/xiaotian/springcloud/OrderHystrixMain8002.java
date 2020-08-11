package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8002.class, args);
        System.out.println("8002加入Hystrix的订单服务启动成功");
    }
}
