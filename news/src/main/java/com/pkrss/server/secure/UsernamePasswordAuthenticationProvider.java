//package com.yjs.server.secure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import com.yjs.server.domain.User;
//import com.yjs.server.service.UserService;
//
///**
// * An implementation of Spring Security {@link AuthenticationProvider} that uses
// * a username and a password for user authentication.
// */
//class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    UserService userService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        User user = this.userService.getUserByMobileAndPassword(authentication.getName(),
//                (String) authentication.getCredentials());
//
//        if (user != null) {
//            Authentication ret = new APIAuthenticationToken(user);
//            SecurityContextHolder.getContext().setAuthentication(ret);
//
//            return ret;
//        }
//
////        return null;
//        throw new AuthenticationServiceException(String.format("The username [%s] could not be authenticated.", authentication.getName()));
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication != null && authentication.getClass().equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
