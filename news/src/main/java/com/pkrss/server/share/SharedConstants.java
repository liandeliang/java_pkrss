package com.pkrss.server.share;

public final class SharedConstants {
    
    public static final class HttpHeader{
        
        /**
         * http header token field,server response
         */
        public static final String HTTP_HEAER_TOKEN = "X-PKRSS-Token";
        
        /**
         * http header pager query,server return data total count
         */
        public static final String HTTP_TOTAL_COUNT = "X-Total-Count";
    }
    
    public static final class Regexp{    
        /**
         * 手机号码正则表达式
         */
        public static final String REGEXP_MOBILE = "1[3|4|5|7|8|][0-9]{9}";
    }
    
    
    public static final class Format{
        /**
         * gson date format
         */
        public static String GSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    }
    
    public static final class Sdk{

        public static final class UMeng{
            public static final String AppKey_EFit = "56d562a367e58ee5b200138a";

            /**
             * user message push aliasType
             */
            public static final String UserMessage_CUSTOM_ALIASTYPE = "id";

            /**
             * simple push max user count
             */
            public static final int UserMessage_Audience_SimpleMaxSize = 50;
            
            /**
             * user push header
             */
            public static final String UserMessage_Field_Data1 = "data1";
           
        }
        
    }
    
    public static final class PushMessage{
    
        public static enum Plateform{
          
            All(0),
          
            Android(1),
          
            Ios(2),
            
            /**
             * Windows phone
             */
            WinPhone(3);
            
            private int value;
            private Plateform(int value){
                this.setValue(value);
            }
            public int getValue() {
                return value;
            }
            public void setValue(int value) {
                this.value = value;
            }
            
            @Override
            public String toString(){
                return "" + this.value;
            }
        }
 
        public static enum Audience{
          
            All(0),
            
            Alias(1),
            
            Tag(2);
            
            private int value;
            private Audience(int value){
                this.setValue(value);
            }
            public int getValue() {
                return value;
            }
            public void setValue(int value) {
                this.value = value;
            }
            
            @Override
            public String toString(){
                return "" + this.value;
            }
        }
        
 
        public static class Data2Class{
         
            public static final String Unspecified = "";
            
            
            /**
             * 用户消息类型， @see: PushMessage_UserNotify
             */
            public static final String userNotify = "userNotify";
        }
        
        public static enum UserNotifyType{
        	
        	Unspeified(0);
            
            private int value;
            private UserNotifyType(int value){
                this.setValue(value);
            }
            public int getValue() {
                return value;
            }
            public void setValue(int value) {
                this.value = value;
            }
            
            @Override
            public String toString(){
                return "" + this.value;
            }
        }
    }
    
    public static final class UrlRequestParams{

        public static final String offsetParam = "offset";
        public static final int offsetParam_default = 0;
     
        public static final String limitParam = "limit";
        public static final int limitParam_default = 20;
    }
}
