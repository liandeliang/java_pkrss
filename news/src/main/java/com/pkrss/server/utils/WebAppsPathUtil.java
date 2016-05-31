package com.pkrss.server.utils;

public class WebAppsPathUtil {
    private static String webAppsPath;

    public static String getWebAppsPath() {
        return webAppsPath;
    }

    public static void setWebAppsPath(String path) {
        webAppsPath = path;
    }
    
    
    private static String sWebInfAbsoulutePath = null;
    
    /*
     * 获取webinf绝对路径
     */
    public static String getWebInfAbsoulutePath(){
        if(sWebInfAbsoulutePath == null){
            String path=Thread.currentThread().getContextClassLoader().getResource("").toString();  
            path=path.replace('/', '\\'); // 将/换成\  
            path=path.replace("file:", ""); //去掉file:  
            path=path.replace("\\classes\\", "\\"); //去掉class\     
            path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...
            path=path.replace('\\', '/'); // 将\换成/
            sWebInfAbsoulutePath = path;
        }
        return sWebInfAbsoulutePath;
    }
}