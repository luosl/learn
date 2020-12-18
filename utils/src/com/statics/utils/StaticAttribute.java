package com.statics.utils;

import java.util.HashMap;
import java.util.Map;

/**
* 测试类属性
* <p>
* 	static 修饰的属性 类属性看在什么时候改变
* </p>
*@author  create by Rudolf
*@date    2018年3月10日 ---- 上午11:12:49
*@problem 
*@answer
*@action
*/
public class StaticAttribute {
	private static Map<String, Object> staticMap = null;
	
	public void getClassAttribute(){
		if(null == staticMap){
			staticMap = new HashMap<String, Object>();
			staticMap.put("time", System.currentTimeMillis());
		}
		System.out.println("类属性值："+staticMap.toString());
	}
	
	public static void main(String[] args) {
		// 第一个对象调用
		new StaticAttribute().getClassAttribute();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("休眠异常");
		}
		// 第二次调用
		new StaticAttribute().getClassAttribute();
	}
}
