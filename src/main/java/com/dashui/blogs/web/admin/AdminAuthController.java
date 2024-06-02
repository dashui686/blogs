package com.dashui.blogs.web.admin;

import cn.hutool.core.util.ObjectUtil;
import com.dashui.blogs.bo.AdminBo;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.freamwork.exception.ServiceException;
import com.dashui.blogs.service.admin.AdminService;
import com.dashui.blogs.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

/**
 * @Author Administrator$
 * @Date 2024/5/26$
 * @PackageName: com.dashui.blogs.web.admin$
 * @ClassName: AdminAuthController$
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping(ADMIN_WEB_KEY+"/auth.Admin")
@RequiredArgsConstructor
public class AdminAuthController extends BaseController {


    private final AdminService adminService;

    /**
     * 分页查询
     *
     * @param adminBo 筛选条件
     * @param pageQuery 分页对象
     * @return 查询结果
     */
    @GetMapping("/index")
    public TableDataInfo<AdminVo> queryByPage(AdminBo adminBo, PageQuery pageQuery) {
        return adminService.queryPage(adminBo,pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/edit")
    public AjaxResult queryById(Long id) {
        if(ObjectUtil.isNull(id)){
            throw new ServiceException("请输入用户ID");
        }
        return AjaxResult.success().data(Constants.DATA,this.adminService.queryVoById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult add(Admin admin) {
        return AjaxResult.success((this.adminService.save(admin)));
    }

    /**
     * 编辑数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @PutMapping
    public AjaxResult edit(Admin admin) {
        return AjaxResult.success((this.adminService.updateById(admin)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public AjaxResult deleteById(Long id) {
        return AjaxResult.success((this.adminService.removeById(id)));
    }
}
