package com.vedeng.message.demo.test;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.vedeng.message.demo.test.Test04_collection_filter.createPerson;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/6
 * @Description:
 * @version:
 */
public class Test {
    public static void main(String[] args) {

        List<Person> people = createPerson();//调用初始化集合的静态方法，初始化一个集合

        List<Person> collect = people.stream().filter(x -> x.getAge() == 33).collect(Collectors.toList());
        collect.stream().forEach( x -> {
            System.out.println(x);
        });

/*        Student stu=new Student();
        stu.setName("JSON");
        stu.setAge("23");
        stu.setAddress("北京市西城区");

        //1、使用JSONObject
        JSONObject json = JSONObject.fromObject(stu);
        //2、使用JSONArray
        JSONArray array=JSONArray.fromObject(stu);

        String strJson=json.toString();
        String strArray=array.toString();

        System.out.println("strJson:"+strJson);
        System.out.println("strArray:"+strArray);*/
    }
}
