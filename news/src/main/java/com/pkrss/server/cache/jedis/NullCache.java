package com.pkrss.server.cache.jedis;


/**
 * 基类token缓存管理，需要后续对过期token进行删除
 */
public abstract class NullCache {
	
	public static final class SharedNull{
		public void close(){
		}
		public boolean exists(String key){
			return false;
		}
		public String get(String key){
			return null;
		}
		public void setex(String key,int n,String v){
		}
		public void expire(String key,int n){
		}
		public void del(String key){
		}
	}
    
    protected SharedNull shardedJedis;
    
    protected SharedNull getJedis(){
        if(shardedJedis == null)
            shardedJedis = new SharedNull();
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
