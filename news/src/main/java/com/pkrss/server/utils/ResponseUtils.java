package com.pkrss.server.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.pkrss.server.base.ResponseFlag;
import com.pkrss.server.http.response.BaseResponse;
import com.pkrss.server.share.ResponseCode;


public final class ResponseUtils {


    public static Map<String,Object> success(HttpServletRequest request) {
        return success(request, null);
    }

    public static <D,T extends BaseResponse<D>> T success(HttpServletRequest request, D data, Class<T> responseClass) {        
        return notify(request, ResponseCode.OK, ResponseCode.OK.getMessage(), data, responseClass);
    }

    public static Map<String,Object> success(HttpServletRequest request, Object dataMap) {
        return notify(request,ResponseCode.OK, ResponseCode.OK.getMessage(), dataMap);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Map<String,Object> fail(HttpServletRequest request, ResponseCode code) {
        return notify(request, code, code.getMessage(), null);
    }
    
    public static Map<String,Object> fail(HttpServletRequest request){
        return fail(request, ResponseCode.Unspecified);
    }
    
    public static Map<String,Object> fail(HttpServletRequest request, String message){
        return fail(request, ResponseCode.Unspecified, message);
    }

    public static Map<String,Object> fail(HttpServletRequest request, ResponseCode code, String message){
        return notify(request, code, code.getMessage()+"("+message+")", null);
    }

    public static Map<String,Object> fail(HttpServletRequest request, Exception e){
        LoggerFactory.getLogger(ResponseUtils.class).error(e.getMessage());
        return fail(request, e.getMessage());
    }
    
    public static <D,T extends BaseResponse<D>> T fail(HttpServletRequest request, ResponseCode code, Class<T> responseClass) {
        return notify(request, code, code.getMessage(), (D)null, responseClass);
    } 
    
    public static <D,T extends BaseResponse<D>> T fail(HttpServletRequest request, Class<T> responseClass){
        return fail(request, ResponseCode.Unspecified, responseClass);
    }  
    
    public static <D,T extends BaseResponse<D>> T fail(HttpServletRequest request, String message, Class<T> responseClass){
        return fail(request, ResponseCode.Unspecified, message, responseClass);
    }
    
    public static <D,T extends BaseResponse<D>> T fail(HttpServletRequest request, Exception e, Class<T> responseClass) {
        e.printStackTrace();
        LoggerFactory.getLogger(ResponseUtils.class).error(e.getMessage());
        return fail(request,e.getMessage(),responseClass);
    }
    
    public static <D,T extends BaseResponse<D>> T fail(HttpServletRequest request, ResponseCode code, String message, Class<T> responseClass){
        return notify(request, code, message, (D)null, responseClass);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static Map<String,Object> notify(HttpServletRequest request, ResponseCode code, String message, Object dataMap) {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put(ResponseFlag.FLAG_CODE, code.getCode());
        retMap.put(ResponseFlag.FLAG_MESSAGE, message);
        
//        // fixed: 客户端希望data不为null
//        if(dataMap == null)
//            dataMap = new HashMap<String,String>();
        
        retMap.put(ResponseFlag.FLAG_DATA, dataMap);
        
        Map<String,Object> srv_info = new HashMap<String,Object>();        
        // 添加服务器时间
        srv_info.put(ResponseFlag.FLAG_SERVER_TIME, DateTimeUtils.toISO8601Format(new Date()));        
        // 添加服务器ip地址
        srv_info.put(ResponseFlag.FLAG_HOST_ID, request.getLocalAddr());
                
        retMap.put(ResponseFlag.FLAG_SRV_INFO, srv_info);
        
        return retMap;
    }
    
    public static <D extends Object,T extends BaseResponse<D>> T notify(HttpServletRequest request, ResponseCode code, String message, D data, Class<T> responseClass) {
        T r = null;
        try {
            r = responseClass.newInstance();
            r.setCode(code.getCode());
            
            // fixed: 客户端希望data不为null
//            if(data == null){
//                Class<D> d = (Class<D>) responseClass.getField("data").getClass();
//                d.newInstance();
//            }
            
            r.setData(data);
            r.setMessage(message);
            
            BaseResponse.SrvInfo srvInfo = new BaseResponse.SrvInfo();
            
            srvInfo.setServer_time(DateTimeUtils.toISO8601Format(new Date()));
            srvInfo.setHost_id(request.getLocalAddr());
            
            r.setSrv_info(srvInfo);
            
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static String responseToString(BaseResponse<?> response){        
        return JSON.toJSONString(response);
    }
}
