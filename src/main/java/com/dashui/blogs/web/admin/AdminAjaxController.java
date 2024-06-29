package com.dashui.blogs.web.admin;

import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

@RestController(ADMIN_WEB_KEY+"/ajax")
public class AdminAjaxController extends BaseController {




    @GetMapping("getTableList")
    public AjaxResult getFileData(){
        return toAjax(1);
    }

}
