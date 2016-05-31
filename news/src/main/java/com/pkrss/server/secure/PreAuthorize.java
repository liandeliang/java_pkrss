package com.pkrss.server.secure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pkrss.server.constant.ServerConstants;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthorize {
    
    /**
     * 是否支持认证	
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月18日   </p>
     * @author liandeliang
     * @return
     */
    boolean validate() default true;
    
    /**
     * 角色，默认为一般登入用户	
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月18日   </p>
     * @author liandeliang
     * @return
     */
    String role() default ServerConstants.Roles.User;
}
