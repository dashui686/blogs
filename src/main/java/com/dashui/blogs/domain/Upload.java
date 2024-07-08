package com.dashui.blogs.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/3 16:48
 * @PackageName: com.dashui.naruto.domain
 * @ClassName: upload
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "site.upload")
public class Upload {

    private String mode;

    private String maxSize;

    private String mineType;

    private String saveName;

    private String url;

    private Map<String,Object> params;
}
