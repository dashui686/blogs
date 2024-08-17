package com.dashui.blogs.web;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.dashui.blogs.common.core.constants.HttpStatus;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.common.utils.ServletUtils;
import com.dashui.blogs.dto.RefreshToken;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginBody;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginHandlerType;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginType;
import com.dashui.blogs.freamwork.core.saToken.service.IAuthStrategy;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.freamwork.core.websocket.utils.WebSocketUtils;
import com.dashui.blogs.freamwork.exception.ServiceException;
import com.dashui.blogs.service.admin.AdminRuleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;
import static com.dashui.blogs.common.core.constants.WebConstants.COMMON_WEB_KEY;
import static com.dashui.blogs.freamwork.core.saToken.util.LoginHelper.getLoginAdmin;
import static com.dashui.blogs.service.impl.admin.AdminIndexServiceImpl.USER_INFO;

/**
 * @Author Administrator$
 * @Date 2024/4/29$
 * @PackageName: com.dashui.blogs.web.admin$
 * @ClassName: AdminController$
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping(COMMON_WEB_KEY)
public class CommonController {


    private final IAuthStrategy authStrategy;

    /**
     * 重新获取登录认证
     * @param refreshToken
     * @return
     *
     * 场景值    对应常量	含义说明
     * -1	NotLoginException.NOT_TOKEN	未能从请求中读取到有效 token
     * -2	NotLoginException.INVALID_TOKEN	已读取到 token，但是 token 无效
     * -3	NotLoginException.TOKEN_TIMEOUT	已读取到 token，但是 token 已经过期 (详)
     * -4	NotLoginException.BE_REPLACED	已读取到 token，但是 token 已被顶下线
     * -5	NotLoginException.KICK_OUT	已读取到 token，但是 token 已被踢下线
     * -6	NotLoginException.TOKEN_FREEZE	已读取到 token，但是 token 已被冻结
     * -7	NotLoginException.NO_PREFIX	未按照指定前缀提交 token
     */
    @PostMapping("refreshToken")
    public AjaxResult refreshToken(@RequestBody RefreshToken refreshToken, HttpServletRequest httpServletRequest) {

        if(StrUtil.isBlank(refreshToken.getRefreshToken())){
            String token = ServletUtils.getHeader(httpServletRequest, "refreshToken");
            if(StrUtil.isBlank(token)){
                throw new ServiceException("请登录",HttpStatus.UNAUTHORIZED);
            }
            refreshToken.setRefreshToken(token);
        }

        // 获取登录时效
        long tokenTimeout = StpUtil.getTokenTimeout();
        // 活动失效 手动或者自动续费
        long ActiveTimeout = StpUtil.getTokenActiveTimeout();
        // 判断是否过期
        if(String.valueOf(tokenTimeout).equals(NotLoginException.TOKEN_TIMEOUT)){
            // 过期重新登录
            SaSession session =  StpUtil.getTokenSessionByToken(refreshToken.getRefreshToken());
            LoginAdmin admin = (LoginAdmin) session.get("admin");
            LoginAdminVo login = authStrategy.login(new LoginBody(admin.getUsername(),admin.getPassword()));
            StpUtil.getTokenSessionByToken(login.getToken()).set("admin", login);
            return AjaxResult.success().data("token",StpUtil.getTokenValue());
        }

        // 判断是否过期
        if(String.valueOf(ActiveTimeout).equals(NotLoginException.TOKEN_TIMEOUT)){
            // 过期续费
            // StpUtil.getSession().set("admin", login);
            StpUtil.updateLastActiveToNow();
            return AjaxResult.success().data("token",StpUtil.getTokenValue());
        }
        // 没有过期则返回当前token
        return AjaxResult.success().data("token",StpUtil.getTokenValue());
    }
}
