package com.dashui.blogs.common.utils;

import cn.hutool.core.util.PageUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Page;
import cn.hutool.db.ds.simple.SimpleDataSource;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.toolkit.JdbcUtils;
import com.dashui.blogs.common.core.constants.DataSourceConstants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: 数据源工具类
 * @Author tzx
 * @Date: 2022/4/17 14:55
 * @Version 1.0
 */
@Slf4j
public class DatasourceUtil {


    /**
     * 获取主数据源
     *
     * @return
     */
    public static DataSource getDatasourceMaster() {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtil.getBean(DynamicRoutingDataSource.class);
        return dynamicRoutingDataSource.getDataSource(DataSourceConstants.DEFAULT_DATASOURCE_KEY);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource(String id) {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtil.getBean(DynamicRoutingDataSource.class);
        try {
            return dynamicRoutingDataSource.getDataSource(id);
        } catch (Exception e) {
            throw new RuntimeException("获取数据源失败： " + id);
        }
    }

    public static DbType getDataSourceMasterDbType() {
        DynamicDataSourceProperties dynamicDataSourceProperties = SpringUtil.getBean(DynamicDataSourceProperties.class);
        DataSourceProperty datasource = dynamicDataSourceProperties.getDatasource().get(dynamicDataSourceProperties.getPrimary());
        return JdbcUtils.getDbType(datasource.getUrl());
    }



    /**
     * 关闭链接
     *
     * @return
     */
    @SneakyThrows
    public static void close(Connection connection, ResultSet resultSet) {
        if (resultSet != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    /**
     * 构建测试sql
     *
     * @return
     */
    public static String wrapperTestSql(DbType dbType) {
        switch (dbType) {
            case ORACLE:
            case ORACLE_12C:
                return "SELECT 1 FROM DUAL";
            default:
                return "select 1";
        }
    }


    public static DbType getDbType(String datasourceId) {
        DataSource dataSource = getDataSource(datasourceId);
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                return JdbcUtils.getDbType(connection.getMetaData().getURL());
            } catch (Exception e) {
                log.error("获取数据库类型失败！", e);
            } finally {
                DbUtil.close(connection);
            }
        }
        return null;
    }
}
