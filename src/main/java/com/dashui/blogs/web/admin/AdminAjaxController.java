package com.dashui.blogs.web.admin;

import cn.hutool.db.meta.MetaUtil;
import cn.hutool.db.meta.Table;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;

import com.dashui.blogs.service.admin.AdminCrudService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ShardingKey;
import java.util.*;
import java.util.stream.Collectors;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

@RestController
@RequestMapping(ADMIN_WEB_KEY + "/ajax")
@RequiredArgsConstructor
public class AdminAjaxController extends BaseController {

    private final AdminCrudService adminCrudService;
    @GetMapping("/getTableList")
    public R getTableList(@RequestParam HashMap<String,Object> request) {
        DynamicRoutingDataSource bean = SpringUtil.getBean(DynamicRoutingDataSource.class);
        DataSource connection = bean.getDataSource(request.get("connection").toString());
        List<String> tables = MetaUtil.getTables(connection);
        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
        tables.forEach(e->{
            Table tableMeta = MetaUtil.getTableMeta(bean, e);
            HashMap<String, Object> tableData = new HashMap<>();
            tableData.put("table",e);
            tableData.put("comment",tableMeta.getComment());
            tableData.put("connection",request.get("connection").toString());
            tableData.put("prefix","");
            hashMaps.add(tableData);
        });
        return R.list(hashMaps);
    }

    @GetMapping("/getDatabaseConnectionList")
    public R getDatabaseConnectionList() {
        DynamicRoutingDataSource bean = SpringUtil.getBean(DynamicRoutingDataSource.class);
        Map<String, DataSource> dataSources = bean.getDataSources();
        List<HashMap<String, Object>> collect = dataSources.entrySet().stream().map(e -> {
            HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
            try {
                DatabaseMetaData metaData = e.getValue().getConnection().getMetaData();
                String databaseProductName = metaData.getDatabaseProductName(); // 数据库型号
                String databaseProductVersion = metaData.getDatabaseProductVersion(); // 数据库版本
                String userName = metaData.getUserName(); // 驱动名称

                stringObjectHashMap.put("label", databaseProductName+"_"+userName+"_"+databaseProductVersion);
                stringObjectHashMap.put("value", e.getKey());
                stringObjectHashMap.put("key", e.getKey());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return stringObjectHashMap;
        }).collect(Collectors.toList());
        // 这里你可以遍历dataSources来获取所有数据源的信息
        // dataSources.forEach((name, dataSource) -> {
        //     System.out.println("DataSource name: " + name);
        //     // 可以从dataSource获取连接信息等
        // });
        return R.options(collect);
    }

}
