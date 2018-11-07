package com.vedeng.message.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vedeng.message.demo.common.constant.CodeConstants;
import com.vedeng.message.demo.common.exception.AuthException;
import com.vedeng.message.demo.model.Message;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.realm.MyShiroRealm;
import com.vedeng.message.demo.service.impl.MessageServiceImpl;
import com.vedeng.message.demo.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/5
 * @Description: 用户的相关操作
 * @version:1.0
 */
@RestController
public class UserController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private MessageServiceImpl messageService;

    EntityWrapper<User> queryWrapper = new EntityWrapper<User>();
    EntityWrapper<Message> messageEntityWrapper = new EntityWrapper<Message>();

    /**
     * 用户进行登陆
     * @param user
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public ModelAndView getView(HttpServletRequest reques, HttpSession session, User user){
        ModelAndView mv = new ModelAndView("main");

        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户名密码放在realm用
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
        try {
            //登陆操作
            subject.login(token);
            token.setUsername(user.getUserName());
            token.setPassword(MyShiroRealm.getPassword(user.getUserName(),user.getUserPassword()).toCharArray());
            /**
             * 获取用户名
             */
            session.setAttribute("user",user.getUserName());
            mv.addObject("user",user.getUserName());
            //获取留言信息
            mv.addObject("message",messageService.selectList(messageEntityWrapper));
            return mv;
        } catch (AuthenticationException e) {
            token.clear();
            throw new AuthException("登录失败，用户名或密码错误！", CodeConstants.EX_OTHER_CODE);
        }
    }

    /**
     * 页面的跳转
     * @return
     */
    @RequestMapping("loginPage")
    public ModelAndView getPage(){
        return new ModelAndView("/login");
    }




    /**
     * 方法实现说明
     *
     * @return a
     * author Bert
     * @date 2018/11/6 21:10
     */
    @RequestMapping("user")
    public User user(){
        return userService.selectOne(queryWrapper);
    }
}
