package cn.jiyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//生命当前这个应用 是一个EurekaServer
public class JiyunEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiyunEurekaApplication.class, args);
    }

}
