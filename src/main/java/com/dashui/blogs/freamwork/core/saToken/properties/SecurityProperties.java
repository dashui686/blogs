package com.dashui.blogs.freamwork.core.saToken.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;

/**
 * Security 配置属性
 *
 * @author Lion Li
 */
@Data
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    /**
     * 排除路径
     */
    private String[] excludes;

}
