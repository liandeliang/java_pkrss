//package com.yjs.server.cache;
//
//
//import java.util.Map;
//import java.util.Map.Entry;
//
//import redis.clients.jedis.ShardedJedis;
//
//import com.alibaba.fastjson.JSON;
//import com.yjs.server.constant.ServerConfig;
//import com.yjs.server.vo.CourseLiveDetailVO;
//
///**
// * 直播地址缓存管理，需要后续对过期token进行删除
// */
//public final class CourseLiveCache extends BaseMapCache<CourseLiveDetailVO>{
//    
//    /**
//     * 定时清理工作
//     * <p>Description:              </p>
//     * <p>Create Time: 2016年4月14日   </p>
//     * @author liandeliang
//     */
//    public void on_timer_daily(){
//        if(ServerConfig.isLocalhost)
//            return;
//        
//        ShardedJedis shardedJedis = getJedis();
//        Map<String, String> kvs = shardedJedis.hgetAll(hkey);
//        if(kvs == null || kvs.size()==0)
//            return;
//        
//        // 清除今天之前的直播课程url纪录
//        long validDateVal = System.currentTimeMillis() - 24 * 36 * 36 *1000;
//        
//        CourseLiveDetailVO vo;
//        for(Entry<String, String> kv : kvs.entrySet()){
//            vo = JSON.parseObject(kv.getValue(), CourseLiveDetailVO.class);
//            if(vo == null || vo.getCourseEndTime()==null || vo.getCourseEndTime() < validDateVal){
//                shardedJedis.hdel(hkey, kv.getKey());
//                continue;
//            }
//        }
//        
//        closeShardedJedis();
//    }
//    
//}
