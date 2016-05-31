//package com.yjs.server.secure;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//public final class APIAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
//            throws IOException, ServletException {
//        // TODO Auto-generated method stub
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                "Unauthorized: Authentication token was either missing or invalid.");
//    }
//
//}
