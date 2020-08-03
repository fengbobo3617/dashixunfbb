package cn.jiyun.ssm.controller;

import cn.jiyun.ssm.pojo.user;
import cn.jiyun.ssm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller//标明是一个控制器
@RequestMapping("user")//该模块是用户模块
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    @ResponseBody
    public user queryUserById(@PathVariable("id")Long id)
    {
        return  this.userService.queryUserById(id);
    }
    @GetMapping("h1909a")
    @ResponseBody
    public String test(){
        return  "hello user";
    }

    //查看所有用户信息
    @GetMapping("all")
    public String findusers(Model model){
        List<user> users = this.userService.queryAllusers();
        System.out.println("信息为"+users);
        model.addAttribute("users",users);

        //页面
        return  "users";
    }
}
