package com.dashui.blogs.service.impl.admin;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.bo.AdminRuleBo;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.domain.AdminRule;
import com.dashui.blogs.service.admin.AdminRuleService;
import com.dashui.blogs.mapper.admin.AdminRuleMapper;
import com.dashui.blogs.vo.AdminRuleRoute;
import com.dashui.blogs.vo.AdminRuleVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.github.linpeilie.Converter;
import java.util.Collections;
import java.util.HashMap;
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
    private final Converter converter;

    public List<AdminRuleRoute> getRouter(){
        String routeId = adminRuleMapper.getRouteByLoginId(StpUtil.getLoginIdAsLong());
        List<AdminRule> adminRules = this.list(new LambdaQueryWrapper<AdminRule>().in(!Constants.ADMIN_RULE.equals(routeId),AdminRule::getId,StringUtils.split(routeId, ",")));
        return buildMenuRoute(adminRules,0L);
    }

    public List<AdminRuleRoute> buildMenuRoute(List<AdminRule> rule,Long parentId){

        List<AdminRule> parentRoute = rule.stream().filter(e -> {
            return e.getPid().equals(parentId);
        }).collect(Collectors.toList());

        if(CollUtil.isEmpty(parentRoute)){
            return null;
        }

        return parentRoute.stream().map(e -> {
            AdminRuleRoute adminRuleRoute = converter.convert(e, AdminRuleRoute.class);
            adminRuleRoute.setChildren(buildMenuRoute(rule, e.getId()));
            return adminRuleRoute;
        }).collect(Collectors.toList());
    }


    @Override
    public AjaxResult queryPage(AdminRule adminBo, PageQuery pageQuery) {

        return AjaxResult.success();
    }

    @Override
    public TableDataInfo<AdminRuleVo> selectPageVo(AdminRuleBo adminRuleBo, PageQuery pageQuery) {
        IPage<AdminRuleVo> adminRuleVoIPage = adminRuleMapper.selectVoPage(pageQuery.build(), buildQueryWrapper(adminRuleBo));
        return TableDataInfo.build(buildMenuVo(adminRuleVoIPage.getRecords(),0));
    }

    public List<AdminRuleVo> buildMenuVo(List<AdminRuleVo> rule,Integer parentId){
        List<AdminRuleVo> parentRoute = rule.stream().filter(e -> {
            return e.getPid().equals(parentId);
        }).collect(Collectors.toList());
        if(CollUtil.isEmpty(parentRoute)){
            return null;
        }
        return parentRoute.stream().peek(e -> e.setChildren(buildMenuVo(rule, e.getId()))).collect(Collectors.toList());
    }


    private Wrapper<AdminRule> buildQueryWrapper(AdminRuleBo adminBo) {
        return new QueryWrapper<AdminRule>();
    }

}




