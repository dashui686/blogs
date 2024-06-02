package com.dashui.blogs.mapper.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dashui.blogs.freamwork.core.mybatisplus.mapper.BaseMapperPlus;
import com.dashui.blogs.vo.AdminVo;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Mapper
* @createDate 2024-05-19 20:17:14
* @Entity com.dashui.blogs.domain.Admin
*/
public interface AdminMapper extends BaseMapperPlus<Admin, AdminVo> {

    /**
     * 根据条件分页数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据集合信息
     */
    IPage<AdminVo> selectPageAdminList(@Param("page") Page<Admin> page, @Param(Constants.WRAPPER) Wrapper<Admin> queryWrapper);

    /**
     * 根据ID查询
     *
     * @param queryWrapper 查询条件
     * @return 数据集合信息
     */
    AdminVo getOne(@Param(Constants.WRAPPER) Wrapper<Admin> queryWrapper);
}




