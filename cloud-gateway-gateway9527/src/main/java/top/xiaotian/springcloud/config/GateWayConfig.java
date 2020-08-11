package top.xiaotian.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/11
 */
@Configuration
public class GateWayConfig {

    // 配置路由的另一种方式
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu", r -> r.path("/guonei")
                                                    .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
