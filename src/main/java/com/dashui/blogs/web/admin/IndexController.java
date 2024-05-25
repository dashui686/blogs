package com.dashui.blogs.web.admin;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.stp.StpUtil;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginUser;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.service.admin.AdminIndexService;
import com.dashui.blogs.service.admin.AdminRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;

import java.util.HashMap;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;
import static com.dashui.blogs.freamwork.core.saToken.util.LoginHelper.*;

/**
 * @Author Administrator$
 * @Date 2024/5/19$
 * @PackageName: com.dashui.blogs.web.admin$
 * @ClassName: IndexController$
 * @Description: TODO
 * @Version 1.0
 */
@RequestMapping(ADMIN_WEB_KEY+"/index")
@RequiredArgsConstructor
public class IndexController {


    private final AdminIndexService adminIndexService;
    private final AdminRuleService adminRuleService;

    @GetMapping("/index")
    public AjaxResult index(){
        SiteConfig siteConfig = ConfigUtils.getSiteConfig();
        return AjaxResult.success(new HashMap<String,Object>(){{
            put("adminInfo",new LoginAdminVo(getLoginAdmin()));
            put("menu",adminRuleService.getRouter());
            put("siteConfig",siteConfig);
        }});
    }
}
