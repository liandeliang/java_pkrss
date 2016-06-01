package com.pkrss.server.filter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pkrss.server.base.StatusCode;
import com.pkrss.server.cache.jedis.TokenCache;
import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.http.response.EmptyResponse;
import com.pkrss.server.secure.PreAuthorize;
import com.pkrss.server.secure.UserContext;
import com.pkrss.server.share.ResponseCode;
import com.pkrss.server.utils.AuthUtil;
import com.pkrss.server.utils.ResponseUtils;


public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        TokenCache tokenCache = new TokenCache();
        
        try{
        
            if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
                PreAuthorize authPassport = ((HandlerMethod) handler).getMethodAnnotation(PreAuthorize.class);
                            
                //没有声明需要权限,或者声明不验证权限
                if(authPassport == null || authPassport.validate() == false)
                    return true;
                else{
                    // 需要的角色
                    String requiredRole = authPassport.role();
                    
                    // 自有研发的第三方子系统
                    if(ServerConstants.Roles.SubSys.equals(requiredRole)){
                        // 只判断sign key = token
                        return AuthUtil.isValidSubSysAccess(request);
                    }
                    
                    UserContext userContext = tokenCache.loadContext(request);
                    if(userContext!=null && userContext.getAppendix()!=null){ //如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                        
                        UserContext.Appendix appendix = userContext.getAppendix();
                        
                        tokenCache.refreshUserContextTokenAlive(request, userContext);
    
                        //在这里实现自己的权限验证逻辑
                        
                        if(ServerConstants.Roles.Admin.equals(requiredRole)){
                            // 管理员                            
                            return appendix.getIsSysUser();
                        }
                        
                        // 一般登录用户
                        return true;
                    } else {//如果验证失败
                        //返回错误
                        EmptyResponse responseObject = ResponseUtils.fail(request, ResponseCode.InvalidAuthorization, EmptyResponse.class);
                        String responseString = ResponseUtils.responseToString(responseObject);
                        
                        response.setStatus(StatusCode.UNAUTHORIZED.getStatus());
                        response.setContentType("application/json;charset=UTF-8");
    //                    response.setCharacterEncoding("UTF-8");
                        PrintWriter writer = response.getWriter();
                        writer.write(responseString);
                        writer.close();
                        
    //                    response.sendError(StatusCode.UNAUTHORIZED.getStatus(), responseString);
                        
    //                    response.sendRedirect("errors/invalidAuthorization");
                        return false;
                    }       
                }
            }
            else
                return true;   
        }finally{
            tokenCache.closeShardedJedis();
        }
     }
}
