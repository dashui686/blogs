package com.dashui.blogs.freamwork.core.mybatisplus.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        this.strictInsertFill(metaObject, "create_by", Long.class, StpUtil.getLoginIdAsLong());
        this.strictInsertFill(metaObject, "update_by", Long.class, StpUtil.getLoginIdAsLong());
        this.strictInsertFill(metaObject, "update_time", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "create_time", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        this.strictUpdateFill(metaObject, "update_time", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "update_by", Long.class, StpUtil.getLoginIdAsLong());
    }
}
