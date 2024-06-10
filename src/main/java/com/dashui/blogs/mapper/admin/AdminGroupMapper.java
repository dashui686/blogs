package com.dashui.blogs.mapper.admin;

import com.dashui.blogs.bo.AdminGroupBo;
import com.dashui.blogs.domain.AdminGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dashui.blogs.freamwork.core.mybatisplus.mapper.BaseMapperPlus;
import com.dashui.blogs.vo.AdminGroupVo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_group(管理分组表)】的数据库操作Mapper
* @createDate 2024-05-21 15:27:44
* @Entity com.dashui.blogs.domain.AdminGroup
*/
public interface AdminGroupMapper extends BaseMapperPlus<AdminGroup, AdminGroupVo> {

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


    /**
     * 查询所有分组
     * @param adminGroupBo
     * @return
     */
    List<AdminGroupVo> queryAllList(AdminGroupBo adminGroupBo);
}




