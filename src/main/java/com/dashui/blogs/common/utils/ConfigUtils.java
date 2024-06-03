package com.dashui.blogs.common.utils;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dashui.blogs.common.core.constants.StringConstants;
import com.dashui.blogs.domain.Config;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.service.ConfigService;

/**
 * @Author Administrator$
 * @Date 2024/5/20$
 * @PackageName: com.dashui.blogs.common.utils$
 * @ClassName: ConfigUtils$
 * @Description: TODO
 * @Version 1.0
 */
public class ConfigUtils {

    private static final ConfigService configService = SpringUtils.getBean(ConfigService.class);

    public static String getValueByName(String name){
        Config one = configService.getOne(new LambdaQueryWrapper<Config>().eq(Config::getName, name));
        if(ObjectUtil.isNotNull(one)){
            return one.getValue();
        }
        return StringConstants.EMPTY;
    }

    public static SiteConfig getSiteConfig(){
        SiteConfig bean = SpringUtils.getBean(SiteConfig.class);

        String siteName = getValueByName(SiteConfig.SITE_NAME);
        if(StringUtils.isNotBlank(siteName)){
            bean.setSiteName(siteName);
        }

        String version = getValueByName(SiteConfig.VERSION);
        if(StringUtils.isNotBlank(version)){
            bean.setVersion(version);
        }

        String cdnUrl = getValueByName(SiteConfig.CDN_URL);
        if(StringUtils.isNotBlank(cdnUrl)){
            bean.setCdnUrl(cdnUrl);
        }

        String apiUrl = getValueByName(SiteConfig.API_URL);
        if(StringUtils.isNotBlank(apiUrl)){
            bean.setApiUrl(apiUrl);
        }

        String recordNumber = getValueByName(SiteConfig.RECORD_NUMBER);
        if(StringUtils.isNotBlank(recordNumber)){
            bean.setRecordNumber(recordNumber);
        }
        return bean;
    }
}
