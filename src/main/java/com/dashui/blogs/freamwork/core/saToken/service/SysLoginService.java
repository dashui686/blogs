package com.dashui.blogs.freamwork.core.saToken.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.constants.GlobalConstants;
import com.dashui.blogs.common.utils.ServletUtils;
import com.dashui.blogs.common.utils.SpringUtils;
import com.dashui.blogs.freamwork.core.redis.utils.RedisUtils;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginUser;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginType;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import com.dashui.blogs.freamwork.exception.UserException;
import com.dashui.blogs.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * 登录校验方法
 *
 * @author Lion Li
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class SysLoginService {

    @Value("${user.password.maxRetryCount}")
    private Integer maxRetryCount;

    @Value("${user.password.lockTime}")
    private Integer lockTime;


    // private final ISysPermissionService permissionService;
    // private final ISysSocialService sysSocialService;
    // private final SysUserMapper userMapper;


    /**
     * 绑定第三方用户
     *
     * @param authUserData 授权响应实体
     * @return 统一响应实体
     */
    // public void socialRegister(AuthUser authUserData) {
    //     String authId = authUserData.getSource() + authUserData.getUuid();
    //     // 第三方用户信息
    //     SysSocialBo bo = BeanUtil.toBean(authUserData, SysSocialBo.class);
    //     BeanUtil.copyProperties(authUserData.getToken(), bo);
    //     bo.setUserId(LoginHelper.getUserId());
    //     bo.setAuthId(authId);
    //     bo.setOpenId(authUserData.getUuid());
    //     bo.setUserName(authUserData.getUsername());
    //     bo.setNickName(authUserData.getNickname());
    //     // 查询是否已经绑定用户
    //     List<SysSocialVo> list = sysSocialService.selectByAuthId(authId);
    //     if (CollUtil.isEmpty(list)) {
    //         // 没有绑定用户, 新增用户信息
    //         sysSocialService.insertByBo(bo);
    //     } else {
    //         // 更新用户信息
    //         bo.setId(list.get(0).getId());
    //         sysSocialService.update_byBo(bo);
    //     }
    // }


    /**
     * 退出登录
     */
    public void logout() {
        try {
            LoginUser loginUser = LoginHelper.getLoginUser();
            if (ObjectUtil.isNull(loginUser)) {
                return;
            }
            // 记录日志
            // recordLogininfor(loginUser.getTenantId(), loginUser.getUsername(), Constants.LOGOUT, MessageUtils.message("user.logout.success"));
        } catch (NotLoginException ignored) {
        } finally {
            try {
                StpUtil.logout();
            } catch (NotLoginException ignored) {
            }
        }
    }

    /**
     * 记录登录信息
     *
     * @param tenantId 租户ID
     * @param username 用户名
     * @param status   状态
     * @param message  消息内容
     */
    // public void recordLogininfor(String tenantId, String username, String status, String message) {
    //     LogininforEvent logininforEvent = new LogininforEvent();
    //     logininforEvent.setTenantId(tenantId);
    //     logininforEvent.setUsername(username);
    //     logininforEvent.setStatus(status);
    //     logininforEvent.setMessage(message);
    //     logininforEvent.setRequest(ServletUtils.getRequest());
    //     SpringUtils.context().publishEvent(logininforEvent);
    // }


    /**
     * 构建管理员登录
     */
    public LoginAdmin buildLoginUser(AdminVo adminVo,String password) {
        LoginAdmin loginAdmin = new LoginAdmin();
        loginAdmin.setId(adminVo.getId());
        loginAdmin.setUsername(adminVo.getUsername());
        loginAdmin.setNickname(adminVo.getNickname());
        loginAdmin.setAvatar(adminVo.getAvatar());
        loginAdmin.setLoginTime(LocalDateTime.now());
        loginAdmin.setPassword(password);
        // loginUser.setUserType(user.getUserType());
        // loginUser.setGroupId();
        // loginUser.setMenuPermission(permissionService.getMenuPermission(user.getUserId()));
        // loginUser.setRolePermission(permissionService.getRolePermission(user.getUserId()));
        // loginUser.setDeptName(ObjectUtil.isNull(user.getDept()) ? "" : user.getDept().getDeptName());
        // List<RoleDTO> roles = BeanUtil.copyToList(user.getRoles(), RoleDTO.class);
        // loginUser.setRoles(roles);

        return loginAdmin;
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    // public void recordLoginInfo(Long userId, String ip) {
    //     SysUser sysUser = new SysUser();
    //     sysUser.setUserId(userId);
    //     sysUser.setLoginIp(ip);
    //     sysUser.setLoginDate(DateUtils.getNowDate());
    //     sysUser.setupdate_by(userId);
    //     DataPermissionHelper.ignore(() -> userMapper.update_byId(sysUser));
    // }

    /**
     * 登录校验
     */
    public void checkLogin(LoginType loginType, String username, Supplier<Boolean> supplier) {
        String errorKey = GlobalConstants.PWD_ERR_CNT_KEY + username;
        String loginFail = Constants.LOGIN_FAIL;

        // 获取用户登录错误次数，默认为0 (可自定义限制策略 例如: key + username + ip)
        int errorNumber = ObjectUtil.defaultIfNull(RedisUtils.getCacheObject(errorKey), 0);
        // 锁定时间内登录 则踢出
        if (errorNumber >= maxRetryCount) {
            // recordLogininfor(tenantId, username, loginFail, MessageUtils.message(loginType.getRetryLimitExceed(), maxRetryCount, lockTime));
            throw new UserException(loginType.getRetryLimitExceed(), maxRetryCount, lockTime);
        }

        if (supplier.get()) {
            // 错误次数递增
            errorNumber++;
            RedisUtils.setCacheObject(errorKey, errorNumber, Duration.ofMinutes(lockTime));
            // 达到规定错误次数 则锁定登录
            if (errorNumber >= maxRetryCount) {
                // recordLogininfor(tenantId, username, loginFail, MessageUtils.message(loginType.getRetryLimitExceed(), maxRetryCount, lockTime));
                throw new UserException(loginType.getRetryLimitExceed(), maxRetryCount, lockTime);
            } else {
                // 未达到规定错误次数
                // recordLogininfor(tenantId, username, loginFail, MessageUtils.message(loginType.getRetryLimitCount(), errorNumber));
                throw new UserException(loginType.getRetryLimitCount(), errorNumber);
            }
        }

        // 登录成功 清空错误次数
        RedisUtils.deleteObject(errorKey);
    }

}
