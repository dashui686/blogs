package com.dashui.blogs.web;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSONArray;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.freamwork.config.SiteConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorBetween;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.HashMap;

/**
 * @Author Administrator$
 * @Date 2024/4/29$
 * @PackageName: com.dashui.blogs.web$
 * @ClassName: IndexController$
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("index")
@AllArgsConstructor
public class IndexController {

    private final SiteConfig siteConfig;

    /**
     * 主页配置
     * @return
     */
    @GetMapping("index")
    public AjaxResult index(){
        return AjaxResult.success(new HashMap<String,Object>(){{
            // 打开会员中心
            put("openMemberCenter",true);
            // 菜单
            put("rules", Collections.emptyList());
            // 网站信息
            put("site",siteConfig);
            // 用户信息
            put("userInfo", Collections.emptyList());
        }});
    }
}
