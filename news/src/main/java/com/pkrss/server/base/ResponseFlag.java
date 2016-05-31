package com.pkrss.server.base;

public final class ResponseFlag {

    public static final String FLAG_SUCCESS = "200000";// 请求成功

    public static final String FLAG_FAIL = "500001";// 系统发生业务异常
    
    public static final String FLAG_CODE = "code"; // 状态码

    public static final String FLAG_MESSAGE = "message"; // 提示消息
    
    public static final String FLAG_DATA ="data";  //数据
    
    public static final String FLAG_SRV_INFO ="srv_info";  //服务器信息

    public static final String FLAG_HOST_ID = "host_id";//主机ip

    public static final String FLAG_SERVER_TIME = "server_time";// 服务器时间

    public static final String FLAG_REQUEST_ID = "request_id";// 请求id，uuid格式

}
