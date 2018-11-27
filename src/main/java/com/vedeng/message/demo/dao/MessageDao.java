package com.vedeng.message.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.vedeng.message.demo.model.Message;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.utils.Page;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface MessageDao extends BaseMapper<Message> {

    /**
     * 方法实现说明
     *
     * @param page
     * @return 查询所有的帖子
    * @throws
     * @author Bert
     * @date 2018/11/6 9:02
     */
    List<Message> selectUserList(Page page);


    /**
     * 浏览量每次加1
     * @param messageId
     * @return
     */
    Integer increseById(@Param("messageId") Integer messageId);

    /**
     * 插入消息返回主键
     */
    Integer insertUser(Map<String, Message> map);
}
