package com.dashui.blogs.freamwork.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author Administrator$
 * @Date 2024/4/29$
 * @PackageName: com.dashui.blogs.common.core.site$
 * @ClassName: SiteConfig$
 * @Description: TODO
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "site")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  SiteConfig implements Serializable {

    public static final String CDN_URL = "cdn_url";
    public static final String VERSION = "version";
    public static final String RECORD_NUMBER = "record_number";
    public static final String SITE_NAME = "site_name";

    // cdn地址
    private String cdnUrl;
    // 备案号
    private String recordNumber;
    // 站点名称
    private String siteName;
    // 上传配置
    private String upload;
    // 版本号
    private String version;
}
