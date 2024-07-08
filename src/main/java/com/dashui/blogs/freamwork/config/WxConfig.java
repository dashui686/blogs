package com.dashui.blogs.freamwork.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/6/27 16:24
 * @PackageName: com.dashui.naruto.config
 * @ClassName: WxConfig
 * @Description: TODO
 * @Version 1.0
 */
@ConfigurationProperties("wx")
@Configuration
@Data
public class WxConfig {


    public static final String GRANT_TYPE = "grant_type";
    public static final String GRANT_TYPE_DEFAULT_VALUE = "authorization_code";
    public static final String APPID = "appid";
    public static final String JS_CODE = "js_code";
    public static final String SECRET = "secret";

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    public Map<String,Object> buildLoginRequest(String code){
        Map<String, Object> param = new HashMap<>();
        param.put(WxConfig.GRANT_TYPE,WxConfig.GRANT_TYPE_DEFAULT_VALUE);
        param.put(WxConfig.JS_CODE,code);
        param.put(WxConfig.APPID,appid);
        param.put(WxConfig.SECRET,secret);
        return param;
    }
}
