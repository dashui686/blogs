package com.dashui.blogs.freamwork.core.saToken.enums;

import com.dashui.blogs.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 设备类型
 * 针对多套 用户体系
 *
 * @author Lion Li
 */
@Getter
@AllArgsConstructor
public enum UserType {

    /**
     * pc端
     */
    SYS_USER("sys_admin"),

    /**
     * app端
     */
    APP_USER("sys_user");

    private final String userType;

    public static UserType getUserType(String str) {
        for (UserType value : values()) {
            if (StringUtils.contains(str, value.getUserType())) {
                return value;
            }
        }
        throw new RuntimeException("'UserType' not found By " + str);
    }
}
