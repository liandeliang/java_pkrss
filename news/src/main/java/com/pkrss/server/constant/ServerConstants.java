package com.pkrss.server.constant;

/**
 * 
 * <p>Title: 服务端常量         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年1月28日           </p>
 * @author liandeliang
 */
public final class ServerConstants {
    
//    public static final String SERVER_PACKAGE = "com.yjs.server";
//    public static final String DB_TABLEPREFIX = "yjs_";
    
    /**
     *  
     * <p>Title: 过期常量         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年3月17日           </p>
     * @author liandeliang
     */
    public static final class Expired{
        
        /**
         * token的有效期 秒
         */
        public static final int token_AliveSeconds = 3 * 24 * 60 * 60;
        
        /**
         * token的忽略有效期 毫秒
         */
        public static final long token_IgnoreAliveMilliSeconds = 60 * 60 * 1000;
    }
    
    /**
     * 
     * <p>Title: request的属性         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年3月24日           </p>
     * @author liandeliang
     */
    public static final class RequestAttribute{
        /**
         * 用户id
         */
        public static final String userId = "yjs_user_id";
    }
    
    /**
     * 
     * <p>Title: 时间常量类         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年3月17日           </p>
     * @author liandeliang
     */
    public static final class Time{
        /**
         * http get 连接超时 毫秒
         */
        public static final int HTTP_TIMEOUT_CONNECT = 10*1000;
        
        /**
         * 上课前30分钟通知用户
         */
        public static final int NOTIFY_USER_BEFORE_COURSE_SECONDS = 30 * 60;
    }
    
    /**
     * 
     * <p>Title: 短信验证码         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年4月18日           </p>
     * @author liandeliang
     */
    public static final class Smscode{
        
        /**
         * 短信验证码重复使用
         */
        public static final boolean SMSCODE_REPEATET_USED = false;
        

        /**
         * 短信验证码有效期 毫秒
         */
        public static final long smscode_expiredMilliSeconds = 15*60*1000;
        
        /**
         * 短信验证码模版
         */
        public static final String CONTENT_FORMAT = "验证码：{SMSCODE}，15分钟内输入有效。";
        
        public static final class XuanWu{
        
            /**
             * 短线验证码地址
             */
            public static final String URL = "http://211.147.239.62:9050/cgi-bin/sendsms?username=fzyjs@fzyjs&password=gzbqc8rx&to={mobile}&text={content}&subid=&msgtype=1";
            
            /**
             * 正常的响应码
             */
            public static final String RSP_OK = "0";
            

            /**
             * 内容编码
             */
            public static final String CONTENT_ENCODE = "GBK";
        }
        
// api.duanxin
// aHR0cDovL2FwaS5kdWFueGluLmNtLz9hY3Rpb249c2VuZCZ1c2VybmFtZT03MDIwNjAzMSZwYXNzd29yZD1BMEI1QzcxNzYyNUY3NTRBQjVBRUVFNzVCMEQ2NTNCQSZwaG9uZT17bW9iaWxlfSZjb250ZW50PXtjb250ZW50fSZlbmNvZGU9dXRmOA==
//      100 ok
//      101 验证信息失败  检查username,password是否有误
//      102 短信余额不足  进入个人中心购买充值
//      104 非法字符    检查调用传入参数：content
//      105 内容过多    检查调用传入参数：content
//      106 号码过多    检查调用传入参数：phone
//      107 频率过快    检查发送频率
//      108 号码内容空   检查调用传入参数：phone,content
//      109 账号冻结    咨询帐号是否绑定唯一有效手机号
//      其他  系统升级或其他 联系客服/技术人员
        
    }
    
    /**
     * 
     * <p>Title: 角色模块         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年1月30日           </p>
     * @author liandeliang
     */
    public enum Role {
        GUEST("ROLE_GUEST"),
        USER("ROLE_USER"),
        ADMIN("ROLE_ADMIN");
        
        private String name;
        
        private Role( String name  ){
            this.name = name;
        }

        /**
         * @return Returns the name.
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name to set.
         */
        public void setName(String name) {
            this.name = name;
        }
    }
    
    /**
     * 
     * <p>Title: sdk信息包         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年2月22日           </p>
     * @author liandeliang
     */
    public static final class Sdk{
        /**
         * 
         * <p>Title: 友盟推送 主秘钥         </p>
         * <p>Description: Function Description </p>
         * <p>Copyright: Copyright (c) 2016     </p>
         * <p>Company: YJS Co., Ltd.     </p>
         * <p>Create Time: 2016年2月22日           </p>
         * @author liandeliang
         */
        public static final class UMeng{
            public static final String MasterSecret_EFit = "yk22xo9yytyrdoqfw0l9ix9uarbjz5c5";
        }
        
        /**
         * 
         * <p>Title: 极光推送 主秘钥         </p>
         * <p>Description: Function Description </p>
         * <p>Copyright: Copyright (c) 2016     </p>
         * <p>Company: YJS Co., Ltd.     </p>
         * <p>Create Time: 2016年2月22日           </p>
         * @author liandeliang
         */
        public static final class JPush{
            public static final String MasterSecret_EFit = "af6e079bbee5c3fe836bde82";
        }
        
        public static final class Oss{
            /**
             * oss 的 杭州 endpoint.
             * 公网： http://oss-cn-hangzhou.aliyuncs.com
             * 内网： http://oss-cn-hangzhou-internal.aliyuncs.com
             */
            public static final String Endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

            public static final String ACCESS_KEY_ID = "F0mzy5UGRuORkNZK";
            
            public static final String ACCESS_KEY_SECRET = "TbB5a55FRwieEUKTJ5rIdkEUmoAayP";
            
            /**
             * 图片oss bucket
             */
            public static final String BUCKET_IMGS = "efit-imgs";
            
            /**
             * 图片最终网址前缀
             */
            public static final String IMGS_BASEURL = "http://imgs.51efit.com/";
            
//            public static final String IMGS_SUBURL = "http://imgs.51efit.com/";
            
            /**
             * 视频oss bucket
             */
            public static final String BUCKET_VIDEOS = "efit-video";
            
            /**
             * 视频最终网址前缀
             */
            public static final String VIDEOS_BASEURL = "http://video3.51efit.com/";
            
            /**
             * 临时文件目录
             */
            public static final String PATH_TMP = "tmp/";
        }
    }
    
    /**
     * 
     * <p>Title: 角色常量         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年2月18日           </p>
     * @author liandeliang
     */
    public static final class Roles{
        /**
         * 角色 游客
         */
        public static final String Guest = "Guest";
        
        /**
         * 默认角色 用户
         */
        public static final String User = "User";
        
        /**
         * 角色 开发人员
         * request中需要
         */
//        public static final String Developer = "Developer";
        
        /**
         * 顶级角色 后台管理员
         * 包含 User
         */
        public static final String Admin = "Admin";
        
        /**
         * 自有研发的第三方子系统
         * 客户端request中需要带上 X-Efit-Token=签名字符串
         */
        public static final String SubSys = "SubSys";
    }
    
    /**
     * 
     * <p>Title: 图片模块         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年3月3日           </p>
     * @author liandeliang
     */
    public static final class Images{
        /**
         * 小图片后缀
         */
        public static final String POSTFIX_SMALLIMAGES = "@120w.src";
    }
}
