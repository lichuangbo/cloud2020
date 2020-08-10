package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@SpringBootApplication
public class OrderMain8002 {

    public static void main(String[] args) {
        System.out.println("8002订单服务启动成功");
        SpringApplication.run(OrderMain8002.class, args);
    }
}
