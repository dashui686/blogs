package com.dashui.blogs.web;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSONArray;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.SendEmailEntity;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.service.IndexService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorBetween;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class IndexController extends BaseController {

    private final SiteConfig siteConfig;

    private final IndexService indexService;

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



    /**
     * 联系我
     */
    @PostMapping("concat")
    public AjaxResult senEmail(String name,String message, String email){
        if(StrUtil.isBlank(name)){
            return error("请输入您的姓名");
        }

        if(StrUtil.isBlank(message)){
            return error("请输入您的信息");
        }

        if(StrUtil.isBlank(email)){
            return error("请输入您的邮箱");
        }
        SendEmailEntity build = SendEmailEntity.SendEmailEntityBuilder.aSendEmailEntity()
                .withText(message)
                .withTo("1327674904@qq.com")
                .withFrom(email)
                .withSubject("有用户联系").build();
        return toAjax(indexService.sendEmail(build));
    }

}
