package com.dashui.blogs.service.admin;

import com.dashui.blogs.bo.AdminGroupBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.domain.AdminGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.vo.AdminGroupInfoVo;
import com.dashui.blogs.vo.AdminGroupVo;

/**
* @author Administrator
* @description 针对表【admin_group(管理分组表)】的数据库操作Service
* @createDate 2024-05-21 15:27:44
*/
public interface AdminGroupService extends IService<AdminGroup> {

    AjaxResult selectTreeAll(AdminGroupBo adminGroupBo, PageQuery pageQuery);

    AdminGroupInfoVo queryVoById(Integer id);
}
