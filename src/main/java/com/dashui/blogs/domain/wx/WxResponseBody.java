package com.dashui.blogs.domain.wx;

import lombok.Data;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/6/28 16:04
 * @PackageName: com.dashui.blogs.domain.wx
 * @ClassName: Response
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class WxResponseBody {

    private String openid;
    private String access_token;
    private String session_key;
    private String unionid;

    /**
     * 40029  code 无效  js_code无效
     * 45011  api minute-quota reach limit  mustslower  retry next minute  API 调用太频繁，请稍候再试
     * 40226  code blocked  高风险等级用户，小程序登录拦截 。风险等级详见用户安全解方案
     * -1  system error  系统繁忙，此时请开发者稍候再试
     */
    private String errcode;
    private String errmsg;

}
