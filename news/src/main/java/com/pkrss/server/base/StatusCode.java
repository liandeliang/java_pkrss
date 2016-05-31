package com.pkrss.server.base;

public enum StatusCode {

    OK(200,"OK","请求成功完成"),
    CREATED(201,"CREATED","创建(或执行)完毕"),
    ACCEPTED(202,"ACCEPTED","请求提交成功，稍后将异步地进行处理"),
    NO_CONTENT(204,"NO CONTENT","请求成功，但没有要返回的实体数据"),
    NOT_MODIFIED(304,"NOT MODIFIED","客户端的缓存资源是最新的"),
    BAD_REQUEST(400,"BAD REQUEST","无效请求"),
    UNAUTHORIZED(401,"UNAUTHORIZED","未授权或无效的授权"),
    FORBIDDEN(403,"FORBIDDEN","拒绝访问"),
    NOT_FOUND(404,"NOT FOUND","请求的路径不存在"),
    METHOD_NOT_ALLOWED(405,"METHOD NOT ALLOWED","请求的方法不支持"),
    NOT_ACCEPTABLE(406,"NOT ACCEPTABLE","服务器无法提供请求时指定的数据响应格式"),
    UNSUPPORTED_MEDIA_TYPE(415,"UNSUPPORTED MEDIA TYPE","服务器不支持请求所提交的数据格式"),
    INTERNAL_SERVER_ERROR(500,"INTERNAL SERVER ERROR","服务器内部错误"),
    BAD_GATEWAY(502,"BAD GATEWAY","无效网关"),
    SERVICE_UNAVAILABLE(503,"SERVICE UNAVAILABLE","服务不可用");
    
    //成员变量
    private int  status;
    
    private String code;
    
    private String message;
    
    private StatusCode( int status, String code, String message ){
        this.status = status;
        this.code = code;
        this.message = message;
    }
    
   
    public static String getCode(int status ){
        for(StatusCode sc :StatusCode.values()){
            if(sc.getStatus() == status ){
                return sc.code;
            }
        }
        return null;
    }
    
    public static String getMessage(int status ){
        for(StatusCode sc :StatusCode.values()){
            if(sc.getStatus() == status ){
                return sc.message;
            }
        }
        return null;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
