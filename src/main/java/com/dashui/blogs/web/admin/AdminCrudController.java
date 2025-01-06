package com.dashui.blogs.web.admin;

import cn.hutool.db.meta.Column;
import cn.hutool.db.meta.MetaUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.dashui.blogs.bo.CrudTableBo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.service.admin.AdminCrudService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN_WEB_KEY+"/crud.Crud")
public class AdminCrudController extends BaseController {

    private final AdminCrudService adminCrudService;

    @GetMapping("databaseList")
    public R databaseList() throws SQLException {
        return success(adminCrudService.databaseList());
    }

    @GetMapping("getFileData")
    public R getFileData(HttpServletRequest httpServletRequest) throws SQLException {

        // connection
        // :
        // "mysql"
        // sql
        // :
        // ""
        // table
        // :
        // "test_build"
        // type
        // :
        // "db
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> columns = new HashMap<>();

        DynamicRoutingDataSource bean = SpringUtil.getBean(DynamicRoutingDataSource.class);
        DataSource connection = bean.getDataSource(httpServletRequest.getParameter("connection"));

        Collection<Column> table = MetaUtil.getTableMeta(connection, httpServletRequest.getParameter("table")).getColumns();
        table.forEach(e->{
            // columns.put("id");

        });

        return toAjax(1);
    }


    @GetMapping("checkCrudLog")
    public R checkCrudLog(CrudTableBo crudTableBo){
        return success(adminCrudService.checkCrudLog(crudTableBo));
    }


    @GetMapping("parseFieldData")
    public R parseFieldData(){
        return success(1);
    }
}
