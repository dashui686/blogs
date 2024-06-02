package com.dashui.blogs.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.common.core.service.GroupService;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.mapper.admin.AdminGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_group(管理分组表)】的数据库操作Service实现
* @createDate 2024-05-21 15:27:44
*/
@Service
@RequiredArgsConstructor
public class AdminGroupServiceImpl extends ServiceImpl<AdminGroupMapper, AdminGroup>
    implements AdminGroupService, GroupService {

    private final AdminGroupMapper adminGroupMapper;

    /**
     * 根据管理员ID获取所属分组id
     * @param id 管理员id
     * @return 集合
     */
    @Override
    public List<Long> getAdminGroupIdsByAdminId(Long id) {
        return adminGroupMapper.getAdminGroupIdsByAdminId(id);
    }

    /**
     * 根据管理员ID获取所属分组名
     * @param id 管理员id
     * @return 集合
     */
    @Override
    public List<String> getAdminGroupNamesByAdminId(Long id) {
        return adminGroupMapper.getAdminGroupNamesByAdminId(id);

    }
}




