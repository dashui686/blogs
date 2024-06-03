package com.dashui.blogs.freamwork.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.dashui.blogs.common.utils.ServletUtils;
import com.dashui.blogs.common.utils.SpringUtils;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.freamwork.core.saToken.handler.AllUrlHandler;
import com.dashui.blogs.freamwork.core.saToken.properties.SecurityProperties;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
@RequiredArgsConstructor
public class SaTokenConfigure implements WebMvcConfigurer {

    // 注册拦截器
    private final SecurityProperties securityProperties;

    /**
     * 注册sa-token的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns(securityProperties.getExcludes());

        // 注册路由拦截器，自定义认证规则
        //		registry.addInterceptor(new SaRouteInterceptor((req, res, handler)->{
        //			// 根据路由划分模块，不同模块不同鉴权
        //			SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
        //			SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
        //			SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
        //			SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));
        //			SaRouter.match("/notice/**", r -> StpUtil.checkPermission("notice"));
        //			SaRouter.match("/comment/**", r -> StpUtil.checkPermission("comment"));
        //		})).addPathPatterns("/**");


        // 拿到所有路由进行过滤 不过滤没有mapping的地址
        // 注册路由拦截器，自定义验证规则
        // registry.addInterceptor(new SaInterceptor(handler -> {
        //             AllUrlHandler allUrlHandler = SpringUtils.getBean(AllUrlHandler.class);
        //             // 登录验证 -- 排除多个路径
        //             SaRouter
        //
        //                     // 获取所有的 mapping
        //                     .match(allUrlHandler.getUrls())
        //                     // 对未排除的路径进行检查
        //                     .check(() -> {
        //                         System.out.println(ServletUtils.getRequest());
        //                         // 检查是否登录 是否有token
        //                         StpUtil.checkLogin();
        //
        //                         // 检查 header 与 param 里的 clientid 与 token 里的是否一致
        //                         // String headerCid = ServletUtils.getRequest().getHeader(LoginHelper.CLIENT_KEY);
        //                         // String paramCid = ServletUtils.getParameter(LoginHelper.CLIENT_KEY);
        //                         // String clientId = StpUtil.getExtra(LoginHelper.CLIENT_KEY).toString();
        //                         // if (!StringUtils.equalsAny(clientId, headerCid, paramCid)) {
        //                         //     // token 无效
        //                         //     throw NotLoginException.newInstance(StpUtil.getLoginType(),
        //                         //             "-100", "客户端ID与Token不匹配",
        //                         //             StpUtil.getTokenValue());
        //                         // }
        //
        //                         // 有效率影响 用于临时测试
        //                         // if (log.isDebugEnabled()) {
        //                         //     log.info("剩余有效时间: {}", StpUtil.getTokenTimeout());
        //                         //     log.info("临时有效时间: {}", StpUtil.getTokenActivityTimeout());
        //                         // }
        //
        //                     });
        //         })).addPathPatterns("/**")
        //         // 排除不需要拦截的路径
        //         .excludePathPatterns(securityProperties.getExcludes());
    }
}
