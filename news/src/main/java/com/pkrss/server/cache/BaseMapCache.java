package com.pkrss.server.cache;


import com.alibaba.fastjson.JSON;

/**
 * 键值对 缓存管理，需要后续对过期token进行删除
 */
class BaseMapCache<T> extends BaseCache{
    
    protected String hkey;
    
    public BaseMapCache(){
        setHKey(this.getClass().getSimpleName());
    }
    
    public BaseMapCache(String hkey){
        setHKey(hkey);
    }
    
    protected void setHKey(String hkey){
        this.hkey = hkey;
    }
    
    /**
     * 加载栏位对应的对象	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月14日   </p>
     * @author liandeliang
     * @param field
     * @return
     */
    public T loadObject(Object field, Class<T> cls){
        String s = getJedis().hget(hkey,field.toString());
        if (s == null || s.length()==0)
            return null;
        return JSON.parseObject(s, cls);
    }
    
    /**
     * 对象是否存在	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月15日   </p>
     * @author liandeliang
     * @param field
     * @return
     */
    public boolean exists(Object field){
        return getJedis().hexists(hkey,field.toString());
    }

    /**
     * 保存对象	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月14日   </p>
     * @author liandeliang
     * @param field
     * @param obj
     */
    public void saveObject(Object field, Object obj){
        String s = null;
        String f = field.toString();
        
        if(obj!=null)
            s = JSON.toJSONString(obj);
        if(s == null || s.length()==0)
            getJedis().hdel(hkey,f);
        else
            getJedis().hset(hkey, f, s);
    }
    
    /**
     * 清除	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月14日   </p>
     * @author liandeliang
     */
    public void clear(){
        getJedis().del(hkey);
    }
    
}
