package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain8002.class, args);
        System.out.println("8002订单服务启动成功");
    }
}
