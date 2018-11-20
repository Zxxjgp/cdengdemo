package com.vedeng.message.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/20 19:15
 * @Description //TODO 测试雨晨那个测试接口的调用
 * @version: 1.0
 */
@RestController
@RequestMapping("api/test")
public class ApiController {

    @RequestMapping(headers = "version = v1" , value = "clint")
    public String sendData(){

        return "我是测试";
    }
}
