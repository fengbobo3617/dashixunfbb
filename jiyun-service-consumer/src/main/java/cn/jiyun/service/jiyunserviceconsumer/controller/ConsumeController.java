package cn.jiyun.service.jiyunserviceconsumer.controller;

import cn.jiyun.service.jiyunserviceconsumer.pojo.User;
import cn.jiyun.service.jiyunserviceconsumer.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "getUsersFallBack")
public class ConsumeController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    @HystrixCommand//(fallbackMethod = "getUsersFallBack")
    public String findAll(@RequestParam("ids")List<Long> ids){
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
     /*   if(ids.get(0)==1){
            throw  new RuntimeException("太忙了.....");
        }*/
        return  this.userService.queryUserByIds(ids).toString();

    }
   /* public String getUsersFallBack(){
        return "请求失败,稍后重试";

    }*/
}
