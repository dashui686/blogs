package com.dashui.blogs.service.admin;

import com.dashui.blogs.bo.AdminBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.vo.AdminVo;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Service
* @createDate 2024-05-01 00:19:56
*/
public interface AdminService extends IService<Admin> {

    TableDataInfo<AdminVo> queryPage(AdminBo adminBo, PageQuery pageQuery);

    AdminVo queryVoById(Long id);
}
