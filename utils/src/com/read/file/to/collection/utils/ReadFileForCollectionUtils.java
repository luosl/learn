package com.read.file.to.collection.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* 读取文件到集合工具类
*@author  create by Rudolf
*@date    2018年3月10日 ---- 上午11:57:17
*@problem 
*@answer
*@action
*/
public class ReadFileForCollectionUtils {
	
	private static final String filePath1 = "src/com/read/file/to/collection/utils/1.txt";
	private static final String filePath2 = "src/com/read/file/to/collection/utils/2.txt";
	public static final String ECODING = "UTF-8";
	
	public static void main(String[] args) {
		ReadFileForCollectionUtils.readFileToMap(filePath2);
		ReadFileForCollectionUtils.readStringToListMap(filePath1);
	}
	
	public static Map<String, Object> readFileToMap(String path){
		Map<String, Object> result = new HashMap<String,Object>();
		InputStreamReader insReader = null;
		BufferedReader br = null;
		try {
			insReader = new InputStreamReader(
							new FileInputStream(
									new File(path)), ECODING);
			br = new BufferedReader(insReader);
			String line = null;
			while(null != (line = br.readLine())){
				result.put(line, line);
			}
			if(null != result && !result.isEmpty()){
				System.out.println(result.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在："+path);
		} catch (UnsupportedEncodingException e) {
			System.out.println("无法读取的编码格式");
		} catch (IOException e) {
			System.out.println("读取文件IO异常");
		} finally {
			if(null != insReader){
				try {
					insReader.close();
				} catch (IOException e) {
					System.out.println("关闭insReader流出错");
				}
				insReader = null;
			}
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("关闭br流出错");
				}
				br = null;
			}
		}
		return result;
	}
	
	public static List<String> readFileToList(String path){
		List<String> result = new ArrayList<String>();
		InputStreamReader insReader = null;
		BufferedReader br = null;
		try {
			insReader = new InputStreamReader(
							new FileInputStream(
									new File(path)), ECODING);
			br = new BufferedReader(insReader);
			String line = null;
			while(null != (line = br.readLine())){
				result.add(line);
			}
			if(null != result && !result.isEmpty()){
				System.out.println(result.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在："+path);
		} catch (UnsupportedEncodingException e) {
			System.out.println("无法读取的编码格式");
		} catch (IOException e) {
			System.out.println("读取文件IO异常");
		} finally {
			if(null != insReader){
				try {
					insReader.close();
				} catch (IOException e) {
					System.out.println("关闭insReader流出错");
				}
				insReader = null;
			}
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("关闭br流出错");
				}
				br = null;
			}
		}
		return result;
	}
	
	public static Set<String> readFileToSet(String path){
		Set<String> result = new HashSet<String>();
		InputStreamReader insReader = null;
		BufferedReader br = null;
		try {
			insReader = new InputStreamReader(
							new FileInputStream(
									new File(path)), ECODING);
			br = new BufferedReader(insReader);
			String line = null;
			while(null != (line = br.readLine())){
				result.add(line);
			}
			if(null != result && !result.isEmpty()){
				System.out.println(result.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在："+path);
		} catch (UnsupportedEncodingException e) {
			System.out.println("无法读取的编码格式");
		} catch (IOException e) {
			System.out.println("读取文件IO异常");
		} finally {
			if(null != insReader){
				try {
					insReader.close();
				} catch (IOException e) {
					System.out.println("关闭insReader流出错");
				}
				insReader = null;
			}
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("关闭br流出错");
				}
				br = null;
			}
		}
		return result;
	}
	
	public static Map<String, Object> readStringToMap(String source){
		Map<String, Object> result = new HashMap<String,Object>();
		if(null == source || source.isEmpty()){
			return result;
		}
		String[] lines = source.split(",");
		for(String s : lines){
			result.put(s, s);
		}
		if(null != result && !result.isEmpty()){
			System.out.println(result.toString());
		}
		return result;
	}
	
	public static List<Map<String, Object>> readStringToListMap(String path){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		InputStreamReader insReader = null;
		BufferedReader br = null;
		try {
			insReader = new InputStreamReader(
							new FileInputStream(
									new File(path)), ECODING);
			br = new BufferedReader(insReader);
			String line = null;
			Map<String, Object> lineMap = null;
			while(null != (line = br.readLine())){
				lineMap = readStringToMap(line);
				if(null != lineMap && !lineMap.isEmpty()){
					result.add(lineMap);
				}
			}
			if(null != result && !result.isEmpty()){
				System.out.println(result.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在："+path);
		} catch (UnsupportedEncodingException e) {
			System.out.println("无法读取的编码格式");
		} catch (IOException e) {
			System.out.println("读取文件IO异常");
		} finally {
			if(null != insReader){
				try {
					insReader.close();
				} catch (IOException e) {
					System.out.println("关闭insReader流出错");
				}
				insReader = null;
			}
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("关闭br流出错");
				}
				br = null;
			}
		}
		return result;
	}
}
