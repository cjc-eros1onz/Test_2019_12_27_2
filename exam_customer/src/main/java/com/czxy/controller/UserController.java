package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private static final String priKeyPath = "D:\\ras\\ras.pri";
    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
      User bean =  userService.login(user);
      if (bean!=null){
          String token = null;
          try {
              token = JwtUtils.generateToken(bean, 60 * 5, RasUtils.getPrivateKey(priKeyPath));
          } catch (Exception e) {
              e.printStackTrace();
          }
          return BaseResult.ok("登录成功").append("token",token);
      }else{
          return BaseResult.error("登录失败");
      }
    }
}
