package com.dashui.blogs.web;

import cn.dev33.satoken.stp.StpUtil;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginBody;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginHandlerType;
import com.dashui.blogs.freamwork.core.saToken.service.IAuthStrategy;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.freamwork.core.websocket.utils.WebSocketUtils;
import com.dashui.blogs.service.admin.AdminRuleService;
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

}
