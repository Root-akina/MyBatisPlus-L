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
    public void fun01() {
        User user = userMapper.selectById(1);
        log.info("hello:{}", user.toString());
        System.out.println(user.getName());
    }

    @Test
    public void fun02() {
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.gt(User::getAge, 20)
                .likeRight(User::getName, "张");
        List<User> users = userMapper.selectList(lambda);
    }

    @Test
    public void fun03() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.gt(User::getAge, 10).orderByDesc(User::getId);
        List<User> users = userMapper.selectList(lqw);
    }

    @Test
    public void fun04() {
        //并且关系
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //并且关系：10到30岁之间
        lqw.lt(User::getAge, 20).gt(User::getAge, 10);
        List<User> userList = userMapper.selectList(lqw);
        System.out.println(userList);
    }

    @Test
    public void fun05(){
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.gt(User::getId,7).or().gt(User::getAge,20);
        List<User> users = userMapper.selectList(lambda);
    }

    @Test
    public void fun06(){
        Integer minAge=10;  //将来有用户传递进来,此处简化成直接定义变量了
        Integer maxAge=null;  //将来有用户传递进来,此处简化成直接定义变量了
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        if(minAge!=null){
            lqw.gt(User::getAge, minAge);
        }
        if(maxAge!=null){
            lqw.lt(User::getAge, maxAge);
        }
        List<User> userList = userMapper.selectList(lqw);
        System.out.println(userList);
    }
}
