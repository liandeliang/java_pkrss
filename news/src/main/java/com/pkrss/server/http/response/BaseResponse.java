package com.pkrss.server.http.response;

import java.io.Serializable;

/**
 * <p>Title: 返回对象基类         </p>
 * <p>Description: 子类必须传递模板参数T </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年1月26日           </p>
 * @author liandeliang
 */
public class BaseResponse<T> implements Serializable{
    /**	
     * Member Description
     */
    
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private int code;
    
    /**
     * 响应消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 服务器调试信息
     */
    private SrvInfo srv_info = new SrvInfo();
    
    public static final class SrvInfo{
        private String server_time;
        private String host_id = "";
        
        public String getServer_time() {
            return server_time;
        }
        public void setServer_time(String server_time) {
            this.server_time = server_time;
        }
        public String getHost_id() {
            return host_id;
        }
        public void setHost_id(String host_id) {
            this.host_id = host_id;
        }
        
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return Returns the srv_info.
     */
    public SrvInfo getSrv_info() {
        return srv_info;
    }

    /**
     * @param srv_info The srv_info to set.
     */
    public void setSrv_info(SrvInfo srv_info) {
        this.srv_info = srv_info;
    }
    
    
}
