package com.vedeng.message.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vedeng.message.demo.common.exception.CrudException;
import com.vedeng.message.demo.dao.MessageDao;
import com.vedeng.message.demo.dao.UserDao;
import com.vedeng.message.demo.model.Message;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.service.MessageService;

import com.vedeng.message.demo.utils.DateUtils;
import com.vedeng.message.demo.utils.ObjectUtils;
import com.vedeng.message.demo.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description:
 * @version:
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message>  implements MessageService {

    @Resource
    private UserDao userDao;

    /**
     * 帖子的发布
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = CrudException.class)
    public boolean insert(Message entity) {
        entity.setAddTime(System.currentTimeMillis());
        entity.setModTime(System.currentTimeMillis());
        entity.setCreator(1);
        return super.insert(entity);
    }

    /**
     * 帖子的分页查询
     * @param page
     * @return
     */
    @Override
    public Page<Message> selectUserList(Page<Message> page) {
        /**
         * 查询帖子
         */
        List<Message> list = baseMapper.selectUserList(page);
        page.setCount(page.getTotal());
        page.setList(list);
        return page;
    }

    /**
     * 方法实现说明
     *
     * @param messageId
     * @return Integer
    * @throws
     * @author Bert
     * @date 2018/11/7 10:38
     */
    @Override
    public Integer increseById(Integer messageId) {
        return baseMapper.increseById(messageId);
    }

    @Override
    public Integer insertUser(Map<String, Message> map) {
        return baseMapper.insertUser(map);
    }

    /**
     * 查询帖子
     * @param id
     * @return
     */
    @Override
    public Message selectById(Serializable id) {
        //查询帖子信息
        Message message = super.selectById(id);
        if (!ObjectUtils.isEmpty(message)){
            //如果帖子存在信息，就将用户名放在Message里面去
            message.setAddTimes(DateUtils.stampToDate(message.getAddTime().toString()));
            User user = userDao.selectById(message.getCreator());
            // 查询用户列表
            if (!ObjectUtils.isEmpty(user)){
                message.setCreatorName(user.getUserName());
            }
        }
        return message;
    }
}
