//package com.yjs.server.secure;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpRequestResponseHolder;
//import org.springframework.security.web.context.SecurityContextRepository;
//
//import com.yjs.server.cache.MyJedisPool;
//import com.yjs.server.share.SharedConstants;
//import com.yjs.server.utils.StringUtil;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * A {@link SecurityContextRepository} implementation that stores the security context in EHCACHE between requests.
// */
//public final class CacheSecurityContextRepository implements SecurityContextRepository {
//
//    private static final String CACHE_PREFIX = "sc_";
//
//    private String getToken(HttpServletRequest request) {
//        String token = request.getHeader(SharedConstants.HTTP_HEAER_TOKEN);
//        if (token != null)
//            token = token.trim();
//        return token;
//    }
//
//    @Override
//    public boolean containsContext(HttpServletRequest request) {
//        String token = getToken(request);
//        if (StringUtil.isEmpty(token))
//            return false;
//        return MyJedisPool.exists(CACHE_PREFIX + token);
//    }
//
//    @Override
//    public SecurityContext loadContext(HttpRequestResponseHolder holder) {
//        String token = getToken(holder.getRequest());
//        if (StringUtil.isEmpty(token))
//            return SecurityContextHolder.createEmptyContext();
//
//        SecurityContext ret = MyJedisPool.getObject(CACHE_PREFIX + token, SecurityContext.class);
//        if (ret != null)
//            return ret;
//
//        return SecurityContextHolder.createEmptyContext();
//    }
//
//    @Override
//    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = context.getAuthentication();
//
//        if (authentication != null && authentication instanceof APIAuthenticationToken) {
//            APIAuthenticationToken apiAuthenticationToken = (APIAuthenticationToken) authentication;
//            String token = (String) apiAuthenticationToken.getCredentials();
//            if (token != null) {
//                MyJedisPool.setObject(CACHE_PREFIX + token, context);
//            }
//        }
//    }
//}
