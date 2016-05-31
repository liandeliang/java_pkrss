package com.pkrss.server.share;

public enum ResponseCode {

    OK(0, "OK"),
    NotFoundAction(1,"Not found action"),
    InvalidAction(2,"Invalid action"),
    InvalidAuthorization(3,"Invalid token"),
    Unspecified(-1,"Unknown"),
    MobileError(-2,"Account format error"),
    PasswordFormatError(-10,"Password format error"),
    DataNotExist(-13,"Data not exist"),
    UploadFail(-15,"Upload fail"),
    UploadFileNumErr(-16,"Upload file number is not 1");
    
    
    private int code;
    
    private String message;
    
    private ResponseCode( int code, String message ){
        this.code = code;
        this.message = message;
    }
    
    public static String getMessage(int code){
        for(ResponseCode sc :ResponseCode.values()){
            if(sc.getCode() == code ){
                return sc.message;
            }
        }
        return null;
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
    
}
