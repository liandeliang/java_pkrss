package com.pkrss.server.cache.jedis;
//package com.pkrss.server.cache;
//
//import java.util.LinkedList;
//import java.util.List;
//import com.pkrss.server.constant.ServerConfig;
//
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.JedisShardInfo;
//import redis.clients.jedis.ShardedJedis;
//import redis.clients.jedis.ShardedJedisPool;
//
//public final class MyJedisPool {
//
//    // shardedJedis切片连接池,可用于集群
//    private static ShardedJedisPool shardPool;
//    
//    private static ShardedJedisPool getShardedJedisPool(){
//        if(shardPool == null){
//               // 创建jedis池配置实例
//               JedisPoolConfig config = new JedisPoolConfig();
//
//               // 设置池配置项值
//               config.setMaxTotal(Integer.valueOf(ServerConfig.getContextProperty("redis.pool.maxTotal")));
//               config.setMaxIdle(Integer.valueOf(ServerConfig.getContextProperty("redis.pool.maxIdle")));
//               config.setTestOnBorrow(Boolean.valueOf(ServerConfig.getContextProperty("redis.pool.testOnBorrow")));
//               config.setTestOnReturn(Boolean.valueOf(ServerConfig.getContextProperty("redis.pool.testOnReturn")));
//
//               // 创建多个redis共享服务
//               JedisShardInfo jedisShardInfo = new JedisShardInfo(ServerConfig.getContextProperty("redis.ip"), Integer.valueOf(ServerConfig.getContextProperty("redis.port")));
//               
//               jedisShardInfo.setPassword(ServerConfig.getContextProperty("redis.password"));
//
//               List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
//               list.add(jedisShardInfo);
//               // 根据配置文件,创建shared池实例
//               shardPool = new ShardedJedisPool(config, list);
//           }
//        return shardPool;
//    }
//
//    /**
//     * 获得jedis对象	
//     * <p>Description: 关于redis操作，请直接对 返回的ShardedJedis进行操作            </p>
//     * 如果需要释放，请调用 MyJedisPool.destroyJedisObject()方法， 或是直接ShardedJedis.close();
//     * <p>Create Time: 2016年3月24日   </p>
//     * @author liandeliang
//     * @return
//     */
//    public static ShardedJedis createJedisObject() {        
//        return getShardedJedisPool().getResource();
//    }
//    
//    /**
//     * 归还 jedis对象
//     * <p>Description:              </p>
//     * <p>Create Time: 2016年3月24日   </p>
//     * @author liandeliang
//     * @param shardedJedis
//     */
//    public static void destroyJedisObject(ShardedJedis shardedJedis){
//        shardedJedis.close();
//    }
//}
