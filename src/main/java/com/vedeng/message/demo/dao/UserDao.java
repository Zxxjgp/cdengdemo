package com.vedeng.message.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vedeng.message.demo.model.TestMap;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.test.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface UserDao extends BaseMapper<User> {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    User selectUserByLoginName(@Param("userName") String userName);

    /**
     * <b>Description:</b><br>
     *  测试map的传参 方式
     *
     * @param : 为了测试map传递参数的
     * @return :
     * @Note <b>Author:</b> Bert <br>
     * <b>Date:</b> 2018/11/23 15:38
     */
    User testMapfindUser(Map<String,String> map);

    Integer inertMapfindUser(Map<String, TestMap> map);

    TestMap findTestCanshu( @Param("name") String uaserName);
    Integer insertUser(TestMap testMap);

    TestMap findUser(String id);

    List<TestMap> findByList(List<String> list);

    TestMap getUs(String id);

    List<TestMap> listMap(@Param("id") String id);

    List<TestMap> setMap(@Param("setList") Set<String> setList);

    List<TestMap> moHuSearch ( @Param("mapName") String mapName);
}
