package cn.jiyun.zuul.jiyunzull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启网关模式
@EnableDiscoveryClient //发现获取注册中心的信息
public class JiyunZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiyunZullApplication.class, args);
    }

}
