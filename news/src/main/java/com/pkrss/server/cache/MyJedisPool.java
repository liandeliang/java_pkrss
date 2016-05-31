package com.pkrss.server.cache;

import java.util.LinkedList;
import java.util.List;
import com.pkrss.server.constant.ServerConfig;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public final class MyJedisPool {

    // shardedJedis切片连接池,可用于集群
    private static ShardedJedisPool shardPool;
    
    private static ShardedJedisPool getShardedJedisPool(){
        if(shardPool == null){
               // 加载redis配置文件
//               ResourceBundle bundle = ResourceBundle.getBundle("redis");
//               if (bundle == null) {
//                   throw new IllegalArgumentException("[redis.properties] is not found!");
//               }
               // 创建jedis池配置实例
               JedisPoolConfig config = new JedisPoolConfig();
               
//               String ip = ServerConfig.getContextProperty("redis.ip");

               // 设置池配置项值
               config.setMaxTotal(Integer.valueOf(ServerConfig.getContextProperty("redis.pool.maxTotal")));
               config.setMaxIdle(Integer.valueOf(ServerConfig.getContextProperty("redis.pool.maxIdle")));
               config.setTestOnBorrow(Boolean.valueOf(ServerConfig.getContextProperty("redis.pool.testOnBorrow")));
               config.setTestOnReturn(Boolean.valueOf(ServerConfig.getContextProperty("redis.pool.testOnReturn")));

               // 创建多个redis共享服务
               JedisShardInfo jedisShardInfo = new JedisShardInfo(ServerConfig.getContextProperty("redis.ip"), Integer.valueOf(ServerConfig.getContextProperty("redis.port")));
               
               jedisShardInfo.setPassword(ServerConfig.getContextProperty("redis.password"));

               List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
               list.add(jedisShardInfo);
               // 根据配置文件,创建shared池实例
               shardPool = new ShardedJedisPool(config, list);
           }
        return shardPool;
    }

    /**
     * 获得jedis对象	
     * <p>Description: 关于redis操作，请直接对 返回的ShardedJedis进行操作            </p>
     * 如果需要释放，请调用 MyJedisPool.destroyJedisObject()方法， 或是直接ShardedJedis.close();
     * <p>Create Time: 2016年3月24日   </p>
     * @author liandeliang
     * @return
     */
    public static ShardedJedis createJedisObject() {        
        return getShardedJedisPool().getResource();
    }
    
    /**
     * 归还 jedis对象
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月24日   </p>
     * @author liandeliang
     * @param shardedJedis
     */
    public static void destroyJedisObject(ShardedJedis shardedJedis){
        shardedJedis.close();
    }

//
//    //Method  ---begin
    
//    public static void setex(String key,int seconds, String value) {
//      getJedisObject().setex(key, seconds, value);
//    }
//    public static void setString(String key, String value) {
//        getJedisObject().set(key, value);
//    }
//
//    public static Long del(String key) {
//        return getJedisObject().del(key);
//    }
//
//    public static String getString(String key) {
//        return getJedisObject().get(key);
//    }
//
//    public static boolean exists(String key) {
//        return getJedisObject().exists(key);
//    }
//    
//    public static void setObject(String key, Object value) {
//        String s = null;
//        if(value != null)
//            s = JSON.toJSONString(value);
//
//        setString(key,s);
//    }
//
//    public static <T> T getObject(String key,Class<T> cls) {
//        T ret = null;
//        
//        String s = getString(key);
//        
//        if(s!=null && s.length()>0){
//            ret = JSON.parseObject(s, cls);
//        }
//        
//        return ret;
//    }
//    
//    public static void setObjects(String key, List<?> values) {
//        String s = null;
//        if(values != null)
//            s = JSON.toJSONString(values);
//
//        setString(key,s);
//    }
//
//    public static <T extends Object> List<T> getObjects(String key,Class<T> cls) {
//        List<T> ret = null;
//        
//        String s = getString(key);
//        
//        if(s!=null && s.length()>0){
//            ret = JSON.parseArray(s, cls);
//        }
//        
//        return ret;
//    }
//
//    public static void addArrayObject(String key,Object value) {
//        @SuppressWarnings("unchecked")
//        List<Object> items = (List<Object>) getObjects(key,value.getClass());
//        if(items == null)
//            items = new ArrayList<Object>();
//        items.add(value);
//        setObjects(key, items);
//    }
//
//    public static void removeArrayObject(String key,Object value) {
//        @SuppressWarnings("unchecked")
//        List<Object> items = (List<Object>) getObjects(key,value.getClass());
//        if(items == null)
//            return;
//        if(items.remove(value)){
//            if(items.size()==0){
//                del(key);
//            }else{
//                setObjects(key, items);
//            }
//        }
//    }
//    
//    public static void expire(String key, int seconds) {
//        getJedisObject().getShard(key).expire(key, seconds);
//    }
//
//    public static void expireAt(String key, long unixTime) {
//        getJedisObject().getShard(key).expireAt(key, unixTime);
//    }
//
//    //Method  ---end
//    
//    /**
//     * 测试shardedJedis池方法
//     */
//    public static void testShardedJedis() {
//        // 从shard池中获取shardJedis实例
//        ShardedJedis shardJedis = getJedisObject();
//        // 向redis服务插入两个key-value对象
//        setString("11111111", "aaa");
//        System.out.println(getString("11111111"));
//        setString("2222222", "bbb");
//        System.out.println(del("2222222"));
//        System.out.println(getString("2222222"));
//        // 释放资源
//        recycleJedisOjbect(shardJedis);
//    }
//
//    public static void main(String[] args) {
//        testShardedJedis();
//        //输出如下
//        /*aaa
//           1
//           null*/
//    }
}
