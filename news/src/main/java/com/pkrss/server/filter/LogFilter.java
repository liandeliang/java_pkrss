package com.pkrss.server.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class LogFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        
        LOG.debug("ip={}, prot={}, contextPath={}, servletPath={}, method={}, contentLength={}", new Object[] {
                req.getLocalAddr(), req.getLocalPort(), req.getContextPath(),
                req.getServletPath(), req.getMethod(), req.getContentLengthLong() });

        filterChain.doFilter(request, response);
    
    }

}
