package com.dashui.blogs.service.impl.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.bo.CrudTableBo;
import com.dashui.blogs.domain.AdminCrud;
import com.dashui.blogs.mapper.admin.AdminCrudMapper;
import com.dashui.blogs.service.admin.AdminCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminCrudServiceImpl extends ServiceImpl<AdminCrudMapper, AdminCrud> implements AdminCrudService  {

    private final AdminCrudMapper adminCrudMapper;

    //TODO: Implement CRUD operations

    @Override
    public Map<String, HashMap<String, String>> databaseList() {;
        List<HashMap<String, Object>> hashMaps = adminCrudMapper.databaseList();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        hashMaps.stream().forEach(e->{
            stringStringHashMap.put(e.get("TABLE_NAME").toString(),e.get("TABLE_NAME") + " - " +e.get("TABLE_COMMENT"));
        });
        return Collections.singletonMap("dbs",stringStringHashMap);
    }

    @Override
    public AdminCrud checkCrudLog(CrudTableBo crudTableBo) {
        AdminCrud one = getOne(new LambdaQueryWrapper<AdminCrud>().select(AdminCrud::getId).eq(AdminCrud::getTableName, crudTableBo.getTable()));
        AdminCrud other = new AdminCrud();
        other.setId(0L);
        return Optional.ofNullable(one).orElse(other);
    }
    // @Override
    // public AdminCrud checkCrudLog(CrudTableBo crudTableBo) {
    //     AdminCrud one = getOne(new LambdaQueryWrapper<AdminCrud>().select(AdminCrud::getId).eq(AdminCrud::getTableName, crudTableBo.getTable()));
    //     AdminCrud other = new AdminCrud();
    //     other.setId(0L);
    //     return Optional.ofNullable(one).orElse(other);
    // }




}
