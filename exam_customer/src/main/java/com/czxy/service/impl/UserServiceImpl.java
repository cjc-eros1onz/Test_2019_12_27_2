package com.czxy.service.impl;

import com.czxy.domain.User;
import com.czxy.mapper.UserMapper;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("cname",user.getCname());
        c.andEqualTo("password",user.getPassword());
        User bean = userMapper.selectOneByExample(example);
        if (bean==null){
            return null;
        }
        return bean;
    }
}
