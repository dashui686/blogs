package com.dashui.blogs.mapper.admin;

import com.dashui.blogs.domain.AdminRule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dashui.blogs.freamwork.core.mybatisplus.mapper.BaseMapperPlus;
import com.dashui.blogs.vo.AdminRuleRoute;
import com.dashui.blogs.vo.AdminRuleVo;

import java.util.HashMap;
import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_rule(菜单和权限规则表)】的数据库操作Mapper
* @createDate 2024-05-21 15:27:44
* @Entity com.dashui.blogs.domain.AdminRule
*/
public interface AdminRuleMapper extends BaseMapperPlus<AdminRule, AdminRuleVo> {

    public String getRouteByLoginId(Long id);

    public HashMap<String,Object> getTitleCount(Integer id);
}




