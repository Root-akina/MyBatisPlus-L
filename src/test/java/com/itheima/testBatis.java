package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class testBatis {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void fun01(){
        User user = userMapper.selectById(1);
        log.info("hello:{}",user.toString());
        System.out.println(user.getName());
    }

    @Test
    public void fun02(){
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.gt(User::getAge,20)
                .likeRight(User::getName,"张");
        List<User> users = userMapper.selectList(lambda);
    }

    @Test
    public void fun03(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.gt(User::getAge,10).orderByDesc(User::getId);
        List<User> users = userMapper.selectList(lqw);
    }
}
