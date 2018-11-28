package com.vedeng.message.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/27 19:56
 * @Description //TODO 反射测试
 * @version: 1.0
 */
public class RefelectService {

	public void sayHello(String name){
		System.out.println("hello"+name);
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
		//获取类的的实例
		Object service = Class.forName(RefelectService.class.getName()).newInstance();
		// 获取方法
		Method method = service.getClass().getMethod("sayHello",String.class);
		//调用反射的方法
		method.invoke(service,"mmmm");
	}
}
