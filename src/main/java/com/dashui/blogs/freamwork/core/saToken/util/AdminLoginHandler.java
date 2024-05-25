package com.dashui.blogs.freamwork.core.saToken.util;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.enums.DeviceType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @Author Administrator$
 * @Date 2024/5/1$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.util$
 * @ClassName: AdminLoginHandler$
 * @Description: TODO
 * @Version 1.0
 *
 * SaManager 负责管理 Sa-Token 所有全局组件。
 * Sa-Token上下文持有类，通过此类快速获取当前环境的相关对象
 * 路由匹配工具类
 * Sa-Token内部工具类，包含一些工具方法
 * 配置对象工厂类，通过此类你可以方便的根据 properties 配置文件创建一个配置对象
 * SpringMVC操作的工具类，位于包：sa-token-spring-boot-starter
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminLoginHandler {

    public static final String LOGIN_ADMIN_KEY = "loginAdmin";
    public static final String ADMIN_KEY = "adminId";


    /**
     * 登录系统
     *
     * @param loginAdmin 登录用户信息
     */
    public static void login(LoginAdmin loginAdmin) {
        loginByDevice(loginAdmin, null);
    }

    /**
     * 登录系统 基于 设备类型
     * 针对相同用户体系不同设备
     *
     * @param loginAdmin 登录用户信息
     */
    public static void loginByDevice(LoginAdmin loginAdmin, DeviceType deviceType) {
        // 缓存
        /**
         * SaStorage - 请求作用域：存储的数据只在一次请求内有效。   request
         * SaSession - 会话作用域：存储的数据在一次会话范围内有效。 session
         * SaApplication - 全局作用域：存储的数据在全局范围内有效。 redis
         */
        SaStorage storage = SaHolder.getStorage();
        // 设置 登录人
        storage.set(LOGIN_ADMIN_KEY, loginAdmin);
        // 设置登录ID
        storage.set(ADMIN_KEY, loginAdmin.getId());
        // SaLoginModel 登录参数设置
        SaLoginModel model = new SaLoginModel();
        if (ObjectUtil.isNotNull(deviceType)) {
            model.setDevice(deviceType.getDevice());
        }
        StpUtil.login(loginAdmin.getId(), model.setExtra(ADMIN_KEY, loginAdmin.getId()));
        StpUtil.getTokenSession().set(LOGIN_ADMIN_KEY, loginAdmin);
    }

    /**
     * 获取用户(多级缓存)
     */
    public static LoginAdmin getLoginAdmin() {
        LoginAdmin loginUser = (LoginAdmin) SaHolder.getStorage().get(LOGIN_ADMIN_KEY);
        if (loginUser != null) {
            return loginUser;
        }
        loginUser = (LoginAdmin) StpUtil.getTokenSession().get(LOGIN_ADMIN_KEY);
        SaHolder.getStorage().set(LOGIN_ADMIN_KEY, loginUser);
        return loginUser;
    }

    /**
     * 获取用户基于token
     */
    public static LoginAdmin getLoginAdmin(String token) {
        return (LoginAdmin) StpUtil.getTokenSessionByToken(token).get(LOGIN_ADMIN_KEY);
    }

    /**
     * 获取用户id
     */
    public static Long getAdminId() {
        Long userId;
        try {
            userId = Convert.toLong(SaHolder.getStorage().get(ADMIN_KEY));
            if (ObjectUtil.isNull(userId)) {
                userId = Convert.toLong(StpUtil.getExtra(ADMIN_KEY));
                SaHolder.getStorage().set(ADMIN_KEY, userId);
            }
        } catch (Exception e) {
            return null;
        }
        return userId;
    }
}
