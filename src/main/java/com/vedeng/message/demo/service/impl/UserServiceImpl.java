package com.vedeng.message.demo.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vedeng.message.demo.dao.UserDao;
import com.vedeng.message.demo.model.TestMap;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description:用户的相关操作
 * @version:1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public List<User> userListPage() {
        return null;
    }

    /**
     * 方法实现说明
     *
     * @param userName
     * @return User
     * @author Bert
     * @date 2018/11/7 13:06
     */
    @Override
    public User selectUserByLoginName(String userName) {
        return baseMapper.selectUserByLoginName(userName);
    }

    @Override
    public User testMapfindUser(Map<String, String> map) {
        return baseMapper.testMapfindUser(map);
    }

    @Override
    public Integer inertMapfindUser(Map<String, TestMap> map) {
        return baseMapper.inertMapfindUser(map);
    }

    @Override
    public TestMap findTestCanshu(String uaserName) {
        return baseMapper.findTestCanshu(uaserName);
    }

    @Override
    public Integer insertUser(TestMap testMap) {
        return baseMapper.insertUser(testMap);
    }

    @Override
    public TestMap findUser(String id) {
        return baseMapper.findUser(id);
    }

    @Override
    public List<TestMap> findByList(List<String> list) {
        return baseMapper.findByList(list);
    }

    @Override
    public TestMap getUs(String id) {
        return baseMapper.getUs(id);
    }

    /**
     * 方法实现说明
     *
     * @param wrapper
     * @return User
     * @author Bert
     * @date 2018/11/7 13:06
     */
    @Override
    public User selectOne(Wrapper<User> wrapper) {
        return super.selectOne(wrapper);
    }
}
