package com.vedeng.message.demo.reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Method;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/28 14:38
 * @Description //TODO
 * @version: 1.0
 */
@Component
public class HelloCglibProxy implements MethodInterceptor {
	private Object target;

	public Object getIntence(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		System.out.println(this.getClass().getName());
		enhancer.setCallback(this);
		return enhancer.create();
	}


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("###################我是JDK的动态代理#########################");
		System.out.println("我准备开始Cglib代理了");

		Object o1 = methodProxy.invokeSuper(o, objects);

		System.out.println("我已经代理Cglib完成了");
		return o1;
	}
}
