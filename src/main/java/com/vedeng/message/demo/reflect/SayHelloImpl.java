package com.vedeng.message.demo.reflect;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/28 13:46
 * @Description //TODO 测试接口的实现
 * @version: 1.0
 */
public class SayHelloImpl implements SayHello {
	@Override
	public void sayHello(String say) {
		System.out.println("hello"+say);
	}

	@Override
	public String eat(String food) {
		System.out.println("I am eating");
		return "我是测试返回按钮";

	}
}
