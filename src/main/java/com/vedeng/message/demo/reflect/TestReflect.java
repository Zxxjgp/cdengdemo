package com.vedeng.message.demo.reflect;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/28 13:59
 * @Description //TODO 测试动态代理
 * @version: 1.0
 */
public class TestReflect {
	public static void main(String[] args) {
		HelloProxy h = new HelloProxy();
		SayHello sayHello =(SayHello)h.bind(new SayHelloImpl());
		sayHello.sayHello(" Bert");
	}
}
