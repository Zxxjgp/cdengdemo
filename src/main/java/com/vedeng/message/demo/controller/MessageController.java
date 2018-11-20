package com.vedeng.message.demo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vedeng.message.demo.common.constant.CodeConstants;

import com.vedeng.message.demo.common.exception.CrudException;
import com.vedeng.message.demo.model.Message;
import com.vedeng.message.demo.model.ReplyMessage;
import com.vedeng.message.demo.service.impl.MessageServiceImpl;

import com.vedeng.message.demo.service.impl.ReplyMessageServiceImpl;
import com.vedeng.message.demo.utils.Page;
import com.vedeng.message.demo.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description: 帖子相关的操作
 * @version: 1.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageServiceImpl messageService;

    @Resource
    private ReplyMessageServiceImpl replyMessageService;

    @Resource
    private  ApiController apiController;


    EntityWrapper<ReplyMessage> replyMessageEntityWrapper = new EntityWrapper<ReplyMessage>();
    /**
     * 增加帖子
     * @param message
     * @return
     */
    @PostMapping(value = "/addMessage")
    @ResponseBody
    public String addMessage(@RequestBody Message message){
        boolean insert = messageService.insert(message);
        //对增加帖子进行判断，如果成功就返回成功的状态码，负责返回失败的状态码
        if (insert){
            return CodeConstants.INSERT_SUCCESS;
        }else {
            return CodeConstants.INSERT_EXCEPTION;
        }
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("/listPage")
    @ResponseBody
    public Page<Message> getListPage(Page page){
        return messageService.selectUserList(page);
    }

    /**
     * 根据id去查询帖子信息
     * @param messageId
     * @return
     */
    @GetMapping("/getById/{messageId}")
    public ModelAndView getById( Page page , @PathVariable String messageId){
        if (!StringUtils.isEmpty(messageId)){
            try {
                messageService.increseById(Integer.valueOf(messageId));
            } catch (NumberFormatException e) {
                throw new CrudException("类型转换异常"+e.getMessage()+e.getStackTrace(),CodeConstants.EXCEPTION_TYPE_CONVERSION);
            }
        }
        ModelAndView mv = new ModelAndView("replyMessage");
        //获取帖子详情
        Message message = null;
        try {
            message = messageService.selectById(Integer.valueOf(messageId));
        } catch (NumberFormatException e) {
            throw new CrudException("类型转换异常"+e.getMessage()+e.getStackTrace(),CodeConstants.EXCEPTION_TYPE_CONVERSION);
        }
        //判断有没有此贴，如果不存在
        if (!ObjectUtils.isEmpty(message)){
            mv.addObject("message",message);
            //获取回复详情
            List<ReplyMessage> replyMessage = replyMessageService.getReplyMessage(page,message.getMessageId()).getList();
            //如果有内容就展示，否则不展示
            if (replyMessage.size() >= 1){
                mv.addObject("replyMessage",replyMessage);
            }
        }
        return   mv;
    }

    @RequestMapping(value = "getString")
    @ResponseBody
    public String getString(){
        com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
        result.put("successData",5);
        result.put("suc",apiController.sendData());

        return result.toString();
    }

    @RequestMapping("jumpSearch")
    public String jumpSearch(){
        return "search";
    }
}
