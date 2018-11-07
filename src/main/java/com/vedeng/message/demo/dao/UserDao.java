package com.vedeng.message.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vedeng.message.demo.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao extends BaseMapper<User> {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    User selectUserByLoginName(@Param("userName") String userName);
}
