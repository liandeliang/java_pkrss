package com.pkrss.server.utils;

import javax.servlet.http.HttpServletRequest;

import com.pkrss.server.constant.ServerConfig;
import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.share.SharedConstants;

/**
 * 
 * <p>Title: 缓存中对token和uid的封装         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年2月23日           </p>
 * @author liandeliang
 */
public final class AuthUtil {
   
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(SharedConstants.HttpHeader.HTTP_HEAER_TOKEN);
        if (token != null)
            token = token.trim();
        return token;
    }
    
    /**
     * 获取当前用户id	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月11日   </p>
     * @author liandeliang
     * @param request
     * @return
     */
    public static Integer getCurUserId(HttpServletRequest request) {
        return (Integer) request.getAttribute(ServerConstants.RequestAttribute.userId);
    }
    
    
    /**
     * userId是否为自己
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月29日   </p>
     * @author liandeliang
     * @param request
     * @param userId
     * @return
     */
    public static boolean isValidSelfUserId(HttpServletRequest request, int userId){
        return ((Integer)userId).equals(getCurUserId(request));
    }
    
    /**
     * 判断合法的第三方开发的访问合法
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月18日   </p>
     * @author liandeliang
     * @param request
     * @return
     */
    public static boolean isValidSubSysAccess(HttpServletRequest request){
        // 只需判断sign = X-Efit-Token
        if(ServerConfig.subSysSignKey.equals(getToken(request)))
            return true;
        
        // 因为php外包的短信接口之前给他们的是使用这个接口，后续会要求使用 替换该方法
        String wxToken = request.getParameter("wxcoop_token");
        return ServerConfig.subSysSignKey.equals(wxToken);
    }
}
