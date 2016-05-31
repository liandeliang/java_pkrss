package com.pkrss.server.cache;


import com.pkrss.server.cache.MyJedisPool;
import redis.clients.jedis.ShardedJedis;

/**
 * 基类token缓存管理，需要后续对过期token进行删除
 */
abstract class BaseCache {
    
    protected ShardedJedis shardedJedis;
    
    protected ShardedJedis getJedis(){
        if(shardedJedis == null)
            shardedJedis = MyJedisPool.createJedisObject();
        return shardedJedis;
    }
    
    public void closeShardedJedis(){
        if(shardedJedis!=null){
            shardedJedis.close();
            shardedJedis = null;
        }
    }
    
    @Override
    protected void finalize( )
    {
        closeShardedJedis();
    }
}
