package com.core.controller;

import com.core.util.Result;
import com.core.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright
 * FileName: UserController
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/11 14:10
 * @since 1.0.0
 */
@RestController
public class UserController {

    @RequestMapping(value="getUser", method=RequestMethod.GET)
    public Object getUser(Long id)
    {
        User userEntity = new User();
        userEntity.setId(id);
        userEntity.setUsername("sir");
        userEntity.setAge(100);
        userEntity.setPassword("123456");
        userEntity.setAddress("成都市");
        return Result.getResult(Result.success,"ok",userEntity);
    }

    /***
     * 获取所有用户列表
     * @return
     */
    @RequestMapping(value="getAllUser", method=RequestMethod.GET)
    public Object getUserList()
    {
        List<User> userEntities = new ArrayList<User>();
        User user = new User(1l, "sir", "123", 10, "SH");
        User user1 = new User(2l, "sir", "1234", 20, "CH");
        User user2 = new User(3l, "sir", "1235", 30, "CD");
        User user3 = new User(4l, "sir", "1236", 40, "BJ");
        userEntities.add(user);
        userEntities.add(user1);
        userEntities.add(user2);
        userEntities.add(user3);

        return userEntities;
    }

    /***
     * 新增用户信息
     * @param userEntity
     * @return
     */
    @RequestMapping(value="addUser", method=RequestMethod.POST)
    public Object addUser( User userEntity)
    {
        System.out.println(userEntity);
        return Result.getResult(Result.success,"ok");
    }



    /***
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteUser", method=RequestMethod.GET)
    public Object deleteUser(Long id)
    {
        System.out.println(id);
        return Result.getResult(Result.fail, "fail");
    }

}
