package com.vedeng.message.demo.controller;

import com.vedeng.message.demo.model.Message;
import com.vedeng.message.demo.model.ReplyMessage;
import com.vedeng.message.demo.model.TestMap;
import com.vedeng.message.demo.reflect.HelloProxy;
import com.vedeng.message.demo.reflect.SayHello;
import com.vedeng.message.demo.reflect.SayHelloImpl;
import com.vedeng.message.demo.service.MessageService;
import com.vedeng.message.demo.service.ReplyMessageService;
import com.vedeng.message.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private ReplyMessageService replyMessageService;

    @Resource
    private UserService userService;
    @Resource
    private MessageService messageService;

    @Resource
    private HelloProxy helloProxy;

    @RequestMapping(headers = "version = v1" , value = "clint")
    public String sendData(){

        return "我是测试";
    }


    public List<ReplyMessage> testList2(){
        List<ReplyMessage> list = replyMessageService.testFindList();
        return list;
    }

    @RequestMapping("testList")
    public ReplyMessage testList(){
       ReplyMessage list = replyMessageService.testFindLists();
        return list;
    }

    @RequestMapping(value = "map")
    public String testMap(){
        Map<String,String> map = new HashMap<>(12);
        map.put("id","5646546");
        map.put("age","16");
        map.put("name","Bert");
        userService.testMapfindUser(map);
        return "ok";
    }
    @RequestMapping(value = "map1")
    public String testMap1(){
        Map<String, TestMap> map = new HashMap<>(12);
        TestMap n = new TestMap();
        n.setId("ewqe2344wqe23wqe23");
        n.setMapAge(100);
        n.setMapName("Jerry");
        map.put("map",n);
        Integer integer = userService.inertMapfindUser(map);
        return "ok"+integer.toString();
    }
    @RequestMapping(value = "testCanshu")
    public TestMap testCanshu(){
        TestMap testCanshu = userService.findTestCanshu("e32132wwe");
        return testCanshu;
    }

    @RequestMapping(value = "testFanhuiZhujian")
    public String testFanhuiZhujian(){
/*        Map<String, Message> map = new HashMap<>(2);
        Message message= new Message();
        message.setMessageType(1);
        message.setMessageTitle("我是花开花落4324324234");
        message.setIsDelete(0);
        message.setAddTime(456468746874L);
        message.setModTime(456468746874L);

        map.put("map",message);
        Integer integer = messageService.insertUser(map);*/
 /*       TestMap map = new TestMap();
        map.setMapName("w4ewqewqewq3432432ewq");
        map.setMapAge(63);
        Integer integer = userService.insertUser(map);*/

   /*     TestMap user = userService.findUser("5");*/
/*            List<String> list = new ArrayList<>(5);
            list.add("3");
            list.add("4");
            list.add("2");
        List<TestMap> byList = userService.findByList(list);
        System.out.println(byList);*/
/*        TestMap us = userService.getUs("1");
        System.out.println(us);*/

/*		List<TestMap> testMaps = userService.listMap("");

		System.out.println(testMaps);

		Set<String> s = new HashSet<>();
		s.add("1");
		s.add("2");
		System.out.println(userService.setMap(s));*/
		List<TestMap> b = userService.moHuSearch("q");
		System.out.println(b);
       SayHello sayHello= (SayHello)helloProxy.bind(new SayHelloImpl());
       sayHello.sayHello("Spring");
        String banana_and_orange_and_pear = sayHello.eat("banana and orange and pear");
        System.out.println(banana_and_orange_and_pear);
        return "ok"+b.toString();
    }

}
