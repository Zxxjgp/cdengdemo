package com.vedeng.message.demo.service;

import com.vedeng.message.demo.model.ReplyMessage;
import com.vedeng.message.demo.utils.Page;

import java.util.List;
/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description: 回复的相关接口
 * @version:1.0
 */
public interface ReplyMessageService {
    /**
     * 得到回复信息
     * @param messageId
     * @return
     */
    Page<ReplyMessage> getReplyMessage(Page page, Integer messageId);


}
