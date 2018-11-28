package com.vedeng.message.demo.service;

import com.vedeng.message.demo.model.TestMap;
import com.vedeng.message.demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description: 用户的相关接口
 * @version:1.0
 */
public interface UserService {
    /**
     * 查询所有的用户
     * @return
     */
    List<User> userListPage();
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    User selectUserByLoginName(String userName);

    User testMapfindUser(Map<String,String> map);

    Integer inertMapfindUser(Map<String, TestMap> map);

    TestMap findTestCanshu(String uaserName);

    Integer insertUser(TestMap testMap);

    TestMap findUser(String id);

    List<TestMap> findByList(List<String> list);

    TestMap getUs(String id);

    List<TestMap> listMap(String id);

    List<TestMap> setMap(Set<String> setList);

    List<TestMap> moHuSearch ( String mapName);
}
