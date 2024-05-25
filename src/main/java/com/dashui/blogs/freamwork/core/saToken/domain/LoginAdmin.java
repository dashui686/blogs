package com.dashui.blogs.freamwork.core.saToken.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author Administrator$
 * @Date 2024/5/1$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.domain$
 * @ClassName: LoginADmin$
 * @Description: TODO
 * @Version 1.0
 */
@Data
@ToString
public class LoginAdmin {

    /**
     * 管理员名称
     */
    private String username;

    /**
     * 管理员名称
     */
    private String nickname;

    /**
     * 管理员头像
     */
    private String avatar;

    /**
     * 管理员分组ID
     */
    private Long groupId;

    /**
     * 管理员ID
     */
    private Long id;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 权限
     */
    private Set<String> auths;

    /**
     * 角色
     */
    private Set<String> roles;
}
