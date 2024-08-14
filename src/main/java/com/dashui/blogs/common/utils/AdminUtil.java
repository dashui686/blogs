package com.dashui.blogs.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.vo.AdminVo;

public class AdminUtil {


    public static final String ADMIN = "admin";


    public static AdminVo getAdmin(){
        return (AdminVo) StpUtil.getSession().get(ADMIN);
    }
}
