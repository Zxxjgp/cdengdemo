package com.vedeng.message.demo.test;

/*import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.utils.DateUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.vedeng.message.demo.test.Test04_collection_filter.createPerson;*/

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;

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

/*        List<Person> people = createPerson();//调用初始化集合的静态方法，初始化一个集合

        List<Person> collect = people.stream().filter(x -> x.getAge() == 33).collect(Collectors.toList());
        collect.stream().forEach( x -> {
            System.out.println(x);
        });*/

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

/*        String str1 =  "你";
        String str2 =  "你";
        String str3 =  "你w";
        String str4 =  "你w";
        int i = (str1+str3).hashCode();
        int j = (str2+str4).hashCode();
        System.out.println(i == j);*/

/*        String s = DateUtils.stampToDate("1541725712131");
        System.out.println(s);

        List<Student> list = new ArrayList<>(2);
        Student student = new Student();
        student.setAddress("江苏南京");
        student.setAge(15);
        student.setData(new Date());
        list.add(student);

        Student set = new Student();
        set.setAddress("江苏延迟");
        set.setAge(16);
        set.setData(new Date());
        list.add(set);
        List<Student> lists = new ArrayList<>(2);
        lists.addAll(list);
        System.out.println(lists.size());
        System.out.println(lists.get(0));
        System.out.println(lists.get(1));
        lists.stream().forEach( x -> {
            System.out.println(x.getAddress());
        });*/
/*        int i=0;
        if(10==101 || (++i)!=0){
            System.out.print("结果为真     "+i);
        }else{
            System.out.println("11111111");
        }*/
/*
        List<Student> list = new ArrayList<>(2);
        Student student = new Student();
        student.setAddress("江苏南京");
        student.setAge(15);
        list.add(student);
        Student set = new Student();
        set.setAddress("江苏南京");
        set.setAge(1);
        set.setAddress("ewqeqweqw");
        list.add(set);
        Student set11 = new Student();
        set11.setAddress("江苏南京");
        set11.setAge(12);
        set11.setAddress("qwq");
        list.add(set11);
        Student set1 = new Student();
        set1.setAddress("江苏南京");
        set1.setAge(122);
        set1.setAddress("");
        list.add(set1);
        System.out.println(list.size());
        List<Student> collect = list.stream().filter( x -> StringUtils.isNotBlank(x.getAddress())).collect(Collectors.toList());
        System.out.println(collect.size());*/

/*        String str = "qwe12231";
        System.out.println(str.replace("SKL2019",str));*/

/*        String str = "DH135456";
        System.out.println(str.trim().startsWith("DH"));*/



/*        lablr :for (int i =0 ; i < 6 ; i++){

            if (i % 2 == 0){
                System.out.println("wqewqewq"+i);
                continue;
            }
            for ( int j = 0 ; j < 6; j++){
                if (j == 4){
                    System.out.println(j+"不要");

                    break ;
                }

            }
            System.out.println(121212);

        }*/

/*        String str = "";
        String ss = null;
        String sss = "   ";
        if (StringUtils.isNotBlank(sss)){
            System.out.println("ssssssssssssssssssssssss");
        }*/


   /*     System.out.println(list.size());
        List<Student> list1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list1.size());*/


/*
        String str = "";
        String sre = " ";
        String strf = null;
        List<String > list = new ArrayList<>();
        list.add("ewqewew");
        Map<String,Object> map = new HashMap<>();
        map.put("32","wq4e3qw");
        Map<String,String> map1 = new HashMap<>();
        System.out.println(StringUtils.isEmpty(map));
        System.out.println(StringUtils.isNotEmpty(sre));
        System.out.println(StringUtils.isEmpty(strf));
        System.out.println(StringUtils.isNotEmpty(map));
        System.out.println(StringUtils.isArray(list));*/

/*        String str = "";
        String sre = " ";
        String strf = null;
        Stu stu = new Stu();
        List<String > list = new ArrayList<>();
        list.add("ewqewew");
        Map<String,Object> map = new HashMap<>();
        map.put("32","wq4e3qw");
        Map<String,String> map1 = new HashMap<>();
        System.out.println(StringUtils.isEmpty(stu));*/
/*
        User user =null;
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.hasText(" w"));
        System.out.println(StringUtils.hasText(" w"));
        System.out.println(StringUtils.replace("1234","2","wewew"));
        System.out.println(StringUtils.capitalize("tRERERrtreHJG"));
*/

/*        System.out.println(StringUtils.isAllBlank(" ","  ",null));
        //首字母
        System.out.println(StringUtils.capitalize("ggJhHkj"));
        System.out.println(StringUtils.contains("qwqwqwq","q"));
        System.out.println(StringUtils.compare("strqq",null));
        System.out.println("we3 ".length());*/

        Comparator<Object> objectComparator = Collections.reverseOrder();
        System.out.println(StringUtils.lowerCase("WQ")+"QW".toLowerCase());
    }
}
