package com.dashui.blogs.service.admin;

import com.dashui.blogs.bo.AdminRuleBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.domain.AdminRule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.dto.AdminRuleDto;
import com.dashui.blogs.vo.AdminRuleRoute;
import com.dashui.blogs.vo.AdminRuleVo;

import java.io.Serializable;
import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_rule(菜单和权限规则表)】的数据库操作Service
* @createDate 2024-05-21 15:27:44
*/
public interface AdminRuleService extends IService<AdminRule> {

    List<AdminRuleRoute> getRouter();

    R queryPage(AdminRule adminBo, PageQuery pageQuery);

    TableDataInfo<AdminRuleVo> selectPageVo(AdminRuleBo adminRuleBo, PageQuery pageQuery);

    AdminRuleVo getVoById(Serializable id);

    boolean add(AdminRuleDto adminRuleDto);

    boolean saveEdit(AdminRuleDto adminRuleDto);
}
