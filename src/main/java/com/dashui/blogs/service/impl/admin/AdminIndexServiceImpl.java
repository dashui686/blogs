package com.dashui.blogs.service.impl.admin;

import com.dashui.blogs.common.utils.ConfigUtils;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.service.ConfigService;
import com.dashui.blogs.service.admin.AdminIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author Administrator$
 * @Date 2024/5/20$
 * @PackageName: com.dashui.blogs.service.impl.admin$
 * @ClassName: IndexServiceImpl$
 * @Description: TODO
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class AdminIndexServiceImpl implements AdminIndexService {

    public static final String USER_INFO = "userInfo";
    public static final String MENU = "menu";
    public static final String SITE_CONFIG = "siteConfig";

    // 服务对象
    private final SiteConfig siteConfig;

    private final ConfigService configService;

    @Override
    public HashMap<String, Object> index() {

        return new HashMap<>(){{
            put(USER_INFO,siteConfig);
            put(MENU,siteConfig);
            put(SITE_CONFIG,siteConfig);
        }};
    }


    public SiteConfig buildSiteConfig(){
        SiteConfig siteConfig = new SiteConfig();
        siteConfig.setSiteName(ConfigUtils.getValueByName(""));
        return siteConfig;
    }
}
