package com.dashui.blogs.service.impl.admin;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.domain.AdminRule;
import com.dashui.blogs.service.admin.AdminRuleService;
import com.dashui.blogs.mapper.admin.AdminRuleMapper;
import com.dashui.blogs.vo.AdminRuleRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【admin_rule(菜单和权限规则表)】的数据库操作Service实现
* @createDate 2024-05-21 15:27:44
*/
@Service
@RequiredArgsConstructor
public class AdminRuleServiceImpl extends ServiceImpl<AdminRuleMapper, AdminRule>
    implements AdminRuleService{

    private final AdminRuleMapper adminRuleMapper;

    public List<AdminRuleRoute> getRouter(){
        String routeId = adminRuleMapper.getRouteId(StpUtil.getLoginIdAsLong());
        List<AdminRule> adminRules = Collections.emptyList();
        if(Constants.ADMIN_RULE.equals(routeId)){
            adminRules = this.list();
        } else {
            adminRules = this.listByIds(Arrays.asList(StringUtils.split(routeId, ",")));
        }


        return buildMenu(adminRules,0);
    }

    public List<AdminRuleRoute> buildMenu(List<AdminRule> rule,Integer parentId){
        List<AdminRule> parentRoute = rule.stream().filter(e -> {
            return e.getPid().equals(parentId);
        }).collect(Collectors.toList());
        if(CollUtil.isEmpty(parentRoute)){
            return null;
        }
        return parentRoute.stream().map(e -> {
            AdminRuleRoute adminRuleRoute = new AdminRuleRoute(e);
            adminRuleRoute.setChildren(buildMenu(rule, e.getId()));
            return adminRuleRoute;
        }).collect(Collectors.toList());
    }

}




