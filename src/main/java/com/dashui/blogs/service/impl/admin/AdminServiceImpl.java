package com.dashui.blogs.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.service.admin.AdminService;
import com.dashui.blogs.mapper.admin.AdminMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Service实现
* @createDate 2024-05-01 00:19:56
*/
@Service
@AllArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    private final AdminMapper adminMapper;

}




