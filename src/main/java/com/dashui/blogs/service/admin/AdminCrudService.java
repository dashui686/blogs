package com.dashui.blogs.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.bo.CrudTableBo;
import com.dashui.blogs.domain.AdminCrud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminCrudService extends IService<AdminCrud> {
    Map<String, HashMap<String, String>> databaseList();

    AdminCrud checkCrudLog(CrudTableBo crudTableBo);

}
