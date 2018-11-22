package com.vedeng.message.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vedeng.message.demo.model.ReplyMessage;
import com.vedeng.message.demo.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ReplyMessageDao extends BaseMapper<ReplyMessage> {
    /**
     * 得到留言
     * @return
     */
    List<ReplyMessage> getReplyMessage(Page page, @Param("messageId") Integer messageId);

    /**
     * 得到回复信息
     * @param replyReplyId
     * @return
     */
    List<ReplyMessage> findByReplyId(@Param("replyReplyId") Integer replyReplyId);

    /**
     *
     * @return
     */
    List<ReplyMessage> testFindList();


    /**
     *
     * @return
     */
    ReplyMessage testFindLists();
}
