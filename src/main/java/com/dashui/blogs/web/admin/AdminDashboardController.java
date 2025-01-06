package com.dashui.blogs.web.admin;

import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.service.admin.AdminIndexService;
import com.dashui.blogs.service.admin.AdminRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;
import static com.dashui.blogs.freamwork.core.saToken.util.LoginHelper.getLoginAdmin;

/**
 * @Author Administrator$
 * @Date 2024/5/19$
 * @PackageName: com.dashui.blogs.web.admin$
 * @ClassName: IndexController$
 * @Description: TODO
 * @Version 1.0
 */
@RequestMapping(ADMIN_WEB_KEY+"/Dashboard")
@RestController
@RequiredArgsConstructor
public class AdminDashboardController {

    private final AdminIndexService adminIndexService;

    private final AdminRuleService adminRuleService;

    @GetMapping("/index")
    public R index(){
        return R.success().data("remark","开源等于互助；开源需要大家一起来支持，支持的方式有很多种，比如使用、推荐、写教程、保护生态、贡献代码、回答问题、分享经验、打赏赞助等；欢迎您加入我们！");
    }
}
