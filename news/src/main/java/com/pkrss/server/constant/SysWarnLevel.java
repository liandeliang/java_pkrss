package com.pkrss.server.constant;

/**
 * 
 * <p>Title: 系统警告级别         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年1月29日           </p>
 * @author liandeliang
 */
public final class SysWarnLevel {
    /**
     * 普通 0:普通 1:警告 2:错误 3:紧急错误
     */
    public static final int normal = 0;
    
    /**
     * 警告
     */
    public static final int warn = 1;
    
    /**
     * 错误
     */
    public static final int error = 2;
    
    /**
     * 紧急错误
     */
    public static final int fault = 3;
}
