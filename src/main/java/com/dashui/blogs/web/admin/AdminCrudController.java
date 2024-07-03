package com.dashui.blogs.web.admin;

import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.service.admin.AdminCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN_WEB_KEY+"/crud.Crud")
public class AdminCrudController extends BaseController {

    private final AdminCrudService adminCrudService;

    @GetMapping("databaseList")
    public AjaxResult databaseList() throws SQLException {
        adminCrudService.databaseList();
        return toAjax(1);
    }

    @GetMapping("getFileData")
    public AjaxResult getFileData() throws SQLException {
        return toAjax(1);
    }


    @GetMapping("checkCrudLog")
    public AjaxResult checkCrudLog(){
        return toAjax(1);
    }
}
