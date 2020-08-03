package cn.jiyun.service.jiyunserviceconsumer.service;

import cn.jiyun.service.jiyunserviceconsumer.dao.UserDao;
import cn.jiyun.service.jiyunserviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryUserByIds(List<Long> ids){
         List<User> users = new ArrayList<>();
         ids.forEach(id->{
             users.add(this.userDao.queryUserById(id));
         });
         return  users;
    }
}
