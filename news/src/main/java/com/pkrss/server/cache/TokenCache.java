package com.pkrss.server.cache;


import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.domain.User;
import com.pkrss.server.secure.UserContext;
import com.pkrss.server.utils.AuthUtil;
import com.pkrss.server.utils.StringUtil;
import com.pkrss.server.utils.UuidUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * token缓存管理，需要后续对过期token进行删除
 */
public final class TokenCache extends BaseCache{
    

    private static final String CACHE_PREFIX = "sc_";

    private static String _getToken(HttpServletRequest request) {
        return AuthUtil.getToken(request);
    }

    /**
     *  是否存在用户缓存
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月15日   </p>
     * @author liandeliang
     * @param request
     */
    public boolean containsContext(HttpServletRequest request) {
        String token = _getToken(request);
        if (token == null || token.length()==0)
            return false;
        return getJedis().exists(CACHE_PREFIX + token);
    }

    /**
     *  加载用户缓存
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月15日   </p>
     * @author liandeliang
     * @param request
     */
    public UserContext loadContext(HttpServletRequest request) {
        return loadContext(_getToken(request));
    }
    
    public UserContext loadContext(String token) {
        if (token == null || token.length()==0)
            return null;

        String s = getJedis().get(CACHE_PREFIX + token);
        
        if(s!=null && s.length()>0)
            return JSON.parseObject(s, UserContext.class);
        
        return null;
    }

    
    /**
     * 创建用户对象缓存	
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月15日   </p>
     * @author liandeliang
     * @param user
     * @param storeId 门店id
     * @param request
     * @return 用户对象缓存   
     */
    public UserContext createContext(User user, Integer storeId, HttpServletRequest request) {
        int userId = user.getId();
        String token = UuidUtil.getUuid();
        
        UserContext.Appendix appendix = new UserContext.Appendix();
        appendix.setToken(token);
        appendix.setUserId(userId);
        appendix.setUpdate_time(new Date().getTime());
        
        UserContext context = new UserContext();
        context.setAppendix(appendix);
        
        String key;
        key = CACHE_PREFIX + token;
        getJedis().setex(key, ServerConstants.Expired.token_AliveSeconds, JSON.toJSONString(context));
        
        return context;
    }
    
    /**
     * 更新 userContext 中系统用户标志	
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月11日   </p>
     * @author liandeliang
     * @param token
     * @param sysUser
     * @return
     */
    public boolean updateUserContextSysUser(String token,boolean sysUser){
        UserContext userContext = loadContext(token);
        if(userContext == null)
            return false;
        userContext.getAppendix().setIsSysUser(sysUser);
        
        String key;
        key = CACHE_PREFIX + token;
        getJedis().setex(key, ServerConstants.Expired.token_AliveSeconds, JSON.toJSONString(userContext));
        
        return true;
    }
    
    /**
     * 更新用户激活时间	
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月17日   </p>
     * @author liandeliang
     * @param token
     * @param userId
     * @return
     */
    public boolean refreshUserContextTokenAlive(HttpServletRequest request, UserContext userContext){
        request.setAttribute(ServerConstants.RequestAttribute.userId, userContext.getAppendix().getUserId());
        
        long time = userContext.getAppendix().getUpdate_time();
        long now = new Date().getTime();
        if(now - time >= ServerConstants.Expired.token_IgnoreAliveMilliSeconds){
            String key;
            key = CACHE_PREFIX + userContext.getAppendix().getToken();
            
            userContext.getAppendix().setUpdate_time(now);
            
            getJedis().expire(key, ServerConstants.Expired.token_AliveSeconds);
        }
        return true;
    }

    /**
     * 	删除用户缓存
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月15日   </p>
     * @author liandeliang
     * @param request
     */
    public void removeContext(HttpServletRequest request){
        String token = _getToken(request);
        if (StringUtil.isEmpty(token))
            return;
        
        getJedis().del(token);
        
    }
}
