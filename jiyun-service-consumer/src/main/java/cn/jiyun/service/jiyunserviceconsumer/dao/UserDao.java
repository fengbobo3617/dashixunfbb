package cn.jiyun.service.jiyunserviceconsumer.dao;

import cn.jiyun.service.jiyunserviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    public User queryUserById(Long id){
        String uri = "http://localhost:8081/user/"+id;
        return  this.restTemplate.getForObject(uri,User.class);
    }
}