package com.dashui.blogs.service.impl.admin;

import com.dashui.blogs.mapper.admin.AdminCrudMapper;
import com.dashui.blogs.service.admin.AdminCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AdminCrudServiceImpl implements AdminCrudService {

    private AdminCrudMapper adminCrudMapper;

    @Override
    public HashMap<String, Object> databaseList() {;
        return adminCrudMapper.databaseList();
    }


    //TODO: Implement CRUD operations


}
