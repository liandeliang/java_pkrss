package com.pkrss.server.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pkrss.server.constant.ServerConfig;
import com.pkrss.server.utils.WebAppsPathUtil;


public class ApplicationServletListener implements ServletContextListener, ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener,
        ServletRequestListener, ServletRequestAttributeListener {

    private static final Logger logger = Logger.getLogger(ApplicationServletListener.class);

    private static ApplicationContext ctx = null;

    public ApplicationServletListener() {
    }

    public void requestDestroyed(ServletRequestEvent arg0) {
    }

    /**
     * 向session里增加属性时调用(用户成功登陆后会调用)
     */
    public void attributeAdded(HttpSessionBindingEvent evt) {

    }

    /**
     * 服务器初始化时调用
     */
    public void contextInitialized(ServletContextEvent evt) {
        logger.debug("服务器启动");
        
        ServletContext servletContext = evt.getServletContext();
        
        ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // 把ApplicationContext存到静态变量里，以便给没有托管到spring的类提供服务

        String webAppsPath = servletContext.getRealPath("/").replace('\\', '/');
        if (!webAppsPath.endsWith("/")) {
            webAppsPath = webAppsPath + "/";
        }
        logger.info("ctx:" + ctx + "ApplicationServletListener=======webAppsPath:" + webAppsPath + "==========");
        // 为其他普通类提供服务
        WebAppsPathUtil.setWebAppsPath(webAppsPath);
        
        // 加载服务器配置
        ServerConfig.initProperties(servletContext);
    }

    public void sessionDidActivate(HttpSessionEvent arg0) {
    }

    public void valueBound(HttpSessionBindingEvent arg0) {
    }

    public void attributeAdded(ServletContextAttributeEvent arg0) {
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0) {
    }

    /**
     * session销毁(用户退出系统时会调用)
     */
    public void sessionDestroyed(HttpSessionEvent evt) {

    }

    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    }

    public void attributeAdded(ServletRequestAttributeEvent evt) {
    }

    public void valueUnbound(HttpSessionBindingEvent arg0) {
    }

    public void sessionWillPassivate(HttpSessionEvent arg0) {
    }

    public void sessionCreated(HttpSessionEvent arg0) {
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0) {
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
    }

    public void contextDestroyed(ServletContextEvent evt) {
        logger.debug("服务器关闭");
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
    }

    public void requestInitialized(ServletRequestEvent arg0) {
    }

}
