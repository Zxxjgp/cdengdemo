package com.vedeng.message.demo.reflect;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/28 13:46
 * @Description //TODO 代理类的实现
 * @version: 1.0
 */
@Component
public class HelloProxy implements InvocationHandler {

	private Object object;


	// 代理对象的绑定
	public Object bind(Object target){
		this.object = target;

		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

	}


	/**
	 * <b>Description:</b><br>
	 *  通过代理对象调用这个方法首先会
	 * @param :a proxy 代理的对象  method调用的方法 args 参数
	 *@return :a
	 *@Note <b>Author:</b> Bert <br>
	 * <b>Date:</b> 2018/11/28 13:58
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("###################我是JDK的动态代理#########################");
		Object result = null;
		System.out.println("我准备开始代理了");
		result = method.invoke(object,args);
		if ( !StringUtils.isEmpty(result)){
			result = "my name is jgg";
		}
		System.out.println("我已经代理完成了");
		return result;
	}
}
