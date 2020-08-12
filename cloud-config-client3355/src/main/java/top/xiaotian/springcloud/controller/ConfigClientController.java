package top.xiaotian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@RestController
@RefreshScope
public class ConfigClientController {

    // config.info是github上配置文件中写的配置
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
