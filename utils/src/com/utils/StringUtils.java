package com.utils;


/**
 * 
 * @author  create by Rudolf
 * @date    2018年6月14日 ---- 上午12:26:58
 * @problem 
 * @answer
 * @action
*/
public class StringUtils {
	public static boolean isNotBlank(String value){
		return !isEmpty(value);
	}
	
	public static boolean isBlank(String value){
		return isEmpty(value);
	}
	
	public static boolean isNotEmpty(String value){
		return !isEmpty(value);
	}
	
	public static boolean isEmpty(String value){
		if(null != value && value.length()>0)
			return false;
		
		return true;
	}
}
