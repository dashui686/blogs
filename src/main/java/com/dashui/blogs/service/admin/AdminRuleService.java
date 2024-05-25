package com.dashui.blogs.service.admin;

import com.dashui.blogs.domain.AdminRule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.vo.AdminRuleRoute;
import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_rule(菜单和权限规则表)】的数据库操作Service
* @createDate 2024-05-21 15:27:44
*/
public interface AdminRuleService extends IService<AdminRule> {

    List<AdminRuleRoute> getRouter();
}
