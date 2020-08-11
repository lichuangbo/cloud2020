package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8003.class, args);
        System.out.println("8003Eureka Server端启动成功");
    }
}
