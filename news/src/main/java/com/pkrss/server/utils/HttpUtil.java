package com.pkrss.server.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.pkrss.server.constant.ServerConstants;

public final class HttpUtil {
    /**
     * 	
     * <p>Description: 获取远程内容，默认编码             </p>
     * <p>Create Time: 2016年1月29日   </p>
     * @author liandeliang
     * @param url
     * @return
     */
    public static String getUrlContent(String url){
        String response = null;
        
        try{
            HttpClient client = new HttpClient();     
            
            client.getHttpConnectionManager().getParams().setConnectionTimeout(ServerConstants.Time.HTTP_TIMEOUT_CONNECT);
            
            HttpMethod method = new GetMethod(url);   
            client.executeMethod(method);
            response = method.getResponseBodyAsString();
    
            
            //释放连接
            method.releaseConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
}
