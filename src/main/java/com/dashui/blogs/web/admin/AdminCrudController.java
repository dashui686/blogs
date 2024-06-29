package com.dashui.blogs.web.admin;

import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
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


    private final DataSource dataSource;

    @GetMapping("getFileData")
    public AjaxResult getFileData() throws SQLException {
        Connection connection = dataSource.getConnection();
        return toAjax(1);
    }


    @GetMapping("checkCrudLog")
    public AjaxResult checkCrudLog(){
        return toAjax(1);
    }
}
