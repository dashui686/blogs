package com.dashui.blogs.web.admin;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.dashui.blogs.common.core.constants.UserConstants;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginBody;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginHandlerType;
import com.dashui.blogs.freamwork.core.saToken.service.IAuthStrategy;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.freamwork.core.websocket.utils.WebSocketUtils;
import com.dashui.blogs.service.admin.AdminRuleService;
import com.dashui.blogs.service.admin.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;
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
@RequestMapping(ADMIN_WEB_KEY+"/Index")
public class AdminController {


    private final ScheduledExecutorService scheduledExecutorService;
    private final AdminRuleService adminRuleService;

    @GetMapping("/index")
    public R index(){
        SiteConfig siteConfig = ConfigUtils.getSiteConfig();

        // 获取登录用户信息
        return R.success(new HashMap<String,Object>(){{
            LoginAdminVo loginVo = new LoginAdminVo(getLoginAdmin());
            loginVo.setToken("Bearer "+ StpUtil.getTokenValue());

            put("adminInfo", loginVo);
            put("menus",adminRuleService.getRouter());
            put("siteConfig",siteConfig);
        }});
    }


    /**
     * 获取登录配置
     * @return
     */
    @GetMapping("login")
    public R login(){
        return R.success(Collections.singletonMap("captcha",false));
    }

    /**
     * 获取登录配置
     * @return
     */
    @PostMapping("login")
    public R login(@RequestBody @Valid LoginBody loginBody){
        // 登录
        LoginAdminVo loginVo = IAuthStrategy.login(loginBody, LoginHandlerType.Admin.getLoginHandlerType());

        Long userId = LoginHelper.getUserId();
        scheduledExecutorService.schedule(() -> {
            WebSocketUtils.sendMessage(userId, "欢迎登录RuoYi-Vue-Plus后台管理系统");
        }, 3, TimeUnit.SECONDS);

        // 返回登录信息
        return R.success(Collections.singletonMap(USER_INFO,loginVo));
    }


}
