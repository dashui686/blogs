package com.dashui.blogs.common.core.service;

import java.util.List;

/**
 * @Author Administrator$
 * @Date 2024/6/2$
 * @PackageName: com.dashui.blogs.common.core.service$
 * @ClassName: GroupService$
 * @Description: TODO
 * @Version 1.0
 */
public interface GroupService {

    /**
     * 根据管理员ID获取所属分组id
     * @param id 管理员id
     * @return 集合
     */
    List<Long> getAdminGroupIdsByAdminId(Long id);

    /**
     * 根据管理员ID获取所属分组名
     * @param id 管理员id
     * @return 集合
     */
    List<String> getAdminGroupNamesByAdminId(Long id);
}
