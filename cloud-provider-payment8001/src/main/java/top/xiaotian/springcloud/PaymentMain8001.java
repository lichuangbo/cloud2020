package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        System.out.println("8001支付服务启动成功");
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
