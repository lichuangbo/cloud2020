package top.xiaotian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8004.class, args);
    }
}
