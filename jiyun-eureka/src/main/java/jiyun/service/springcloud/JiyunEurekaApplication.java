package jiyun.service.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//声明当前应用是一个EurekaServer
public class JiyunEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiyunEurekaApplication.class, args);
    }

}
