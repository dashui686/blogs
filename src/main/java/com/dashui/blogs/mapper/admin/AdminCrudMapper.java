package com.dashui.blogs.mapper.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.bo.CrudTableBo;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.domain.AdminCrud;
import com.dashui.blogs.freamwork.core.mybatisplus.mapper.BaseMapperPlus;
import com.dashui.blogs.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
* @author Administrator
* @description AdminCrudMapper的数据库操作Mapper
* @createDate 2024-05-19 20:17:14
* @Entity
*/
public interface AdminCrudMapper extends BaseMapper<AdminCrud> {

    List<HashMap<String, Object>> databaseList();

    Object checkCrudLog(CrudTableBo crudTableBo);
}




