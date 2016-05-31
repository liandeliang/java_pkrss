package com.pkrss.server.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	/**
	 * 获取属性文件的数据 根据key获取值
	 * @param key
	 * @return
	 */
	public static String findPropertiesKey(String key) {
		
		try {
			Properties prop = getProperties();
			return prop.getProperty(key);
		} catch (Exception e) {
			return "";
		}
		
	}


	public static Properties getProperties(){
		Properties prop = new Properties();
		InputStream in = PropertiesUtils.class.getResourceAsStream("/common_config.properties"); 
		try {
			prop.load(in);
		} catch (Exception e) {
			return null;
		}
		return prop;
	}
	/**
	 * 写入properties信息
	 * @param key 名称
	 * @param value 值
	 */
	public static void modifyProperties(String key, String value) {
		try {
			// 从输入流中读取属性列表（键和元素对）
			Properties prop = getProperties();
			prop.setProperty(key, value);
			String path = PropertiesUtils.class.getResource("/common_config.properties").getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			prop.store(outputFile, "modify");
			outputFile.close();
			outputFile.flush();
		} catch (Exception e) {
		}
	}
	
public static void main(String[] args) {
        
    }
}
