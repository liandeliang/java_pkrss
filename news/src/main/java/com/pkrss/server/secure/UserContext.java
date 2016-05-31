package com.pkrss.server.secure;

import java.io.Serializable;

/**
 * 
 * <p>Title: 缓存用户数据结构         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年2月15日           </p>
 * @author liandeliang
 */
public final class UserContext implements Serializable {
    
    /**	
     * Member Description
     */
    
    private static final long serialVersionUID = 1L;

    /**
     * 
     * <p>Title: 附加用户数据         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年2月15日           </p>
     * @author liandeliang
     */
    public static final class Appendix implements Serializable{
        /**	
         * Member Description
         */
        
        private static final long serialVersionUID = 1L;
        
        /**
         * token
         */
        private String token;
        
        /**
         * 用户id
         */
        private int userId;
        
        /**
         * 是否为系统用户
         */
        private boolean isSysUser;
        
        /**
         * 记录更新时间
         */
        private long update_time;
        
        /**
         * @return Returns the token.
         */
        public String getToken() {
            return token;
        }
        /**
         * @param token The token to set.
         */
        public void setToken(String token) {
            this.token = token;
        }
        /**
         * @return Returns the userId.
         */
        public int getUserId() {
            return userId;
        }
        /**
         * @param userId The userId to set.
         */
        public void setUserId(int userId) {
            this.userId = userId;
        }
        public boolean getIsSysUser() {
            return isSysUser;
        }
        public void setIsSysUser(boolean isSysUser) {
            this.isSysUser = isSysUser;
        }
        public long getUpdate_time() {
            return update_time;
        }
        public void setUpdate_time(long update_time) {
            this.update_time = update_time;
        }
    }
    
    private Appendix appendix;
    
    
    /**
     * @return Returns the appendix.
     */
    public Appendix getAppendix() {
        return appendix;
    }

    /**
     * @param appendix The appendix to set.
     */
    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }
    
    
}
