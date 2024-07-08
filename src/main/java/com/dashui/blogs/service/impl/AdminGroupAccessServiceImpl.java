package com.dashui.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.AdminGroupAccess;
import com.dashui.blogs.service.admin.AdminGroupAccessService;
import com.dashui.blogs.mapper.admin.AdminGroupAccessMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【admin_group_access(管理分组映射表)】的数据库操作Service实现
* @createDate 2024-06-16 16:02:19
*/
@Service
public class AdminGroupAccessServiceImpl extends ServiceImpl<AdminGroupAccessMapper, AdminGroupAccess>
    implements AdminGroupAccessService{

}




