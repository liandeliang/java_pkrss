package com.pkrss.server.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public final class ServerConfig extends PropertyPlaceholderConfigurer {
    
    /**
     * 是否为开发者本机
     */
    public static boolean isLocalhost = false;
    
    /**
     * 子系统 sign key, for wx dev, rtmp script
     */
    public static String subSysSignKey = "";
    
    /**
     * 所有属性
     */
    private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>(); 
    
    public static Map<String, String> getCtxPropertiesMap(){
        return ctxPropertiesMap;
    }
    
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
            Properties props) throws BeansException {  
  
        super.processProperties(beanFactory, props);  
        //load properties to ctxPropertiesMap  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            ctxPropertiesMap.put(keyStr, value);  
        }  
    }  
  
    //static method for accessing context properties  
    public static String getContextProperty(String name) {  
        return ctxPropertiesMap.get(name);  
    }  
    
    /**
     * 初始化	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月19日   </p>
     * @author liandeliang
     * @param servletContext
     */
    public static void initProperties(ServletContext servletContext){        
        loadProperties();
    }
    
    /**
     * 属性
     */
//    private static Properties properties = new Properties();
    
    public static void loadProperties(){
        try {
            String value;
            value = getContextProperty("server.localhost");
            if(value != null && value.length()>0)
                isLocalhost = Boolean.valueOf(value);
            
            value = getContextProperty("server.subSysSignKey");
            if(value != null && value.length()>0)
                subSysSignKey = value;            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
