package com.xml.utils;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.utils.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * xml与json、map互转工具
 * @author  create by Rudolf
 * @date    2018年6月13日 ---- 下午9:16:34
 * @problem 
 * @answer
 * @action
*/
public class XmlUtils {
	/**
	 * map to xml
	 * @param map
	 * @return
	 */
	public static String callMapToXML(Map<String,Object> map) {  
        Logger.getLogger("将Map转成Xml, Map：" + map.toString());  
        StringBuffer sb = new StringBuffer();  
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><XML>");  
        mapToXML(map, sb);  
        sb.append("</XML>");  
        Logger.getLogger("将Map转成Xml, Xml：" + sb.toString());  
        try {  
//            return sb.toString().getBytes("UTF-8");  
        	return sb.toString();
        } catch (Exception e) {  
        	Logger.getLogger(e.toString());  
        }  
        return null;  
    }  
	
	@SuppressWarnings("unchecked")
	private static void mapToXML(Map<String,Object> map, StringBuffer sb) {  
        String key = null;
        Object value = null;
        Object elementList = null;
        String listName = null;
        List<Object> list = null;
        Set<String> set = map.keySet();
        Map<String, Object> innerMap = null;
        for (Iterator<String> it = set.iterator(); it.hasNext();) {  
            key = (String) it.next();  
            value = map.get(key);  
            if (null == value)  
                value = "";  
            // 转list，添加一层
            if (value.getClass().getName().equals("java.util.ArrayList")) {  
                list = (List<Object>) map.get(key);  
                listName = key.substring(0, key.lastIndexOf("List"));
                sb.append("<" + key + ">");  
                for (int i = 0; i < list.size(); i++) { 
                	sb.append("<" + listName + ">");
                	elementList = list.get(i);
                	if(elementList instanceof Map) { 
                		innerMap = (Map<String, Object>) elementList;  
                        mapToXML(innerMap, sb);  
                    } else {  
                        sb.append("<" + elementList + ">" + elementList + "</" + elementList + ">");  
                    } 
                	sb.append("</" + listName + ">");
                }  
                sb.append("</" + key + ">");  
  
            } else if(value instanceof Map) { 
            	sb.append("<" + key + ">");  
            	mapToXML((Map<String, Object>) value, sb);  
                sb.append("</" + key + ">");
            } else {  
                sb.append("<" + key + ">" + value + "</" + key + ">");  
            } 
  
        }  
    }  
	
	/**
	 * jsonArray to xml list
	 * @param arrayStr
	 * @return
	 */
	public static List<String> callJsonArrayToXML(String arrayStr){
		if(StringUtils.isBlank(arrayStr) || !arrayStr.startsWith("[") || !arrayStr.endsWith("]"))
			return null;
		
		List<String> xmls = new ArrayList<String>();
		JSONArray jsonArr = JSONArray.fromObject(arrayStr);
		String xml = null;
		JSONObject jsonObj = null;
		for (int i=0; i<jsonArr.size(); i++){
			jsonObj = jsonArr.optJSONObject(i);
			if (jsonObj.isNullObject() || jsonObj.isEmpty()){
				continue;
			}
			
			xml = callJSONToXML(jsonObj);
			xmls.add(xml);
		}
		return xmls;
	}
	
	/**
	 * JSONObject to xml
	 * @param jsonObj
	 * @return
	 */
	public static String callJSONToXML(JSONObject jsonObj) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> <business>");
		jsonToXML(jsonObj, sb);
		sb.append("</business> ");
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	private static void jsonToXML(JSONObject jsonObj, StringBuffer sb) {
		String key = null;
		String value = null;
		String addKey = null;
		JSONArray jsonAr = null;
		JSONObject innerJSON = null;
		Iterator<String> iterator = jsonObj.keys();
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObj.getString(key);
			if (null == value)
				value = "";
			
			// 是否是JSONArray
			if (value.startsWith("[") && value.endsWith("]")) {
				jsonAr = JSONArray.fromObject(value);
				addKey = key.substring(0, key.lastIndexOf("List"));
				sb.append("<"+key+">");
				for (int i=0; i<jsonAr.size(); i++){
					innerJSON = jsonAr.optJSONObject(i);
					if (innerJSON.isNullObject() || innerJSON.isEmpty())
						continue;
					
					sb.append("<"+addKey+">");
					jsonToXML(jsonObj, sb);
					sb.append("</"+addKey+"> ");
				}
				sb.append("</"+key+"> ");
			} else if (value.startsWith("{") && value.endsWith("}")){
				sb.append("<"+key+">");
				innerJSON = JSONObject.fromObject(value);
				jsonToXML(jsonObj, sb);
				sb.append("</"+key+"> ");
			} else {
				sb.append("<"+key+">"+value+"</"+key+"> ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String outKey = null;
		String inkey = null;
		Map<String, Object> m  = new HashMap<String, Object>();
		Map<String, Object> inm  = new HashMap<String, Object>();
		List<Object> l = new ArrayList<Object>();
		List<Object> inl = new ArrayList<Object>();
		for(int i=0; i<10;i++){
			outKey = "a"+i;
			inkey = "b"+i;
			m.put(outKey, outKey);
			inm.put(inkey, inkey);
		}
		for(int i=0;i<5;i++){
			l.add(inm);
			inl.add(i);
		}
		inl.add(m);
		m.put("outList", l);
		System.out.println(m);
//		byte[] xmlBytes = callMapToXML(m);
		System.out.println(callMapToXML(m));
//		writeFile(xmlBytes);
		System.out.println("aaaa");
		
	}
	
	
}
