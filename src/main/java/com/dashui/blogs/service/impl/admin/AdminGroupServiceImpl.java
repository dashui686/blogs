package com.dashui.blogs.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.mapper.admin.AdminGroupMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【admin_group(管理分组表)】的数据库操作Service实现
* @createDate 2024-05-21 15:27:44
*/
@Service
public class AdminGroupServiceImpl extends ServiceImpl<AdminGroupMapper, AdminGroup>
    implements AdminGroupService{

}




