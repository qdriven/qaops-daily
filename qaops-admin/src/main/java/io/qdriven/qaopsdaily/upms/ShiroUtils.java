package io.qdriven.qaopsdaily.upms;

import io.qdriven.qaopsdaily.upms.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author Patrick
 **/
public class ShiroUtils {

    /**
     * 获取当前登录用户
     *
     * @return User
     */
    public static User getCurrentUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
