package com.dashui.blogs.domain.wx;

import lombok.Data;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/6/28 22:41
 * @PackageName: com.dashui.blogs.domain.wx
 * @ClassName: Request
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class WxRequestBody {

    private String code;
    private String access_token;
}
