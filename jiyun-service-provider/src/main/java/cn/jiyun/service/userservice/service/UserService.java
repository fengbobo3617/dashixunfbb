package cn.jiyun.service.userservice.service;

import cn.jiyun.service.userservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service
public class UserService {
 @Autowired
    private UserMapper userMapper;
 public User queryById(Long id){
     return  this.userMapper.selectByPrimaryKey(id);
 }
}
