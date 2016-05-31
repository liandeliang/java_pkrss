package com.pkrss.server.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.ArrayUtils;

import com.pkrss.server.http.response.BasePageResponse;

public final class BeanUtils {

    private static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);
    /**
     * 	
     * @param obj
     * @param excludeKey  
     * @return
     */
    public static Map<String, Object> transBean2MapExcludeKey(Object obj, String... excludeKey) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (obj == null) {
            return map;
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (!ArrayUtils.contains(excludeKey, key)) {
                        map.put(key, value);
                    }
                }

            }
        } catch (Exception e) {
            LOG.error("transBean2Map Error " + e);
        }
        return map;
    }

    /**
     * 	
     * @param obj
     * @param includeKey
     * @return
     */
    public static Map<String, Object> transBean2MapIncludeKey(Object obj, String... includeKey) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (obj == null) {
            return map;
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (ArrayUtils.contains(includeKey, key)) {
                        map.put(key, value);
                    }
                }

            }
        } catch (Exception e) {
            LOG.error("transBean2MapIncludeKey Error " + e);
        }
        return map;
    }
    
   
    /**
     * 	
     * <p>Description:Map2Bean </p>
     * @param map
     * @param obj
     */
    public static void transMap2Bean(Map<String, Object> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
            LOG.error("transMap2Bean Error " + e);
        }  
  
        return;  
  
    }  
    
    /**
     * 拷贝 src 到 dstClass 类型的新对象中
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月3日   </p>
     * @author liandeliang
     * @param src
     * @param dstClass
     * @return
     */
    public static <S extends Object,D extends S> D toVO(S src,Class<D> dstClass){
        try{
            if(src == null)
                return null;
            D ret = dstClass.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(src,ret);
            return ret;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 拷贝 src 到 dstClass 类型的新分页对象中
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月3日   </p>
     * @author liandeliang
     * @param src
     * @param dstClass
     * @return
     */
    public static <S extends Object,D extends S> BasePageResponse.Data<D> toVO(BasePageResponse.Data<S> src,Class<D> dstClass){

        if(src == null)
            return null;
        
        BasePageResponse.Data<D> ret = new BasePageResponse.Data<D>();
        
        org.springframework.beans.BeanUtils.copyProperties(src,ret);
        
        List<D> dstlist = new ArrayList<D>();
        List<S> srclist = src.getList();
        if(srclist!=null){
            for(S s : srclist){
                dstlist.add(toVO(s, dstClass));
            }
            ret.setList(dstlist);
        }
        
        return ret;
    }


    public static void main(String[] args) {

    }

}
