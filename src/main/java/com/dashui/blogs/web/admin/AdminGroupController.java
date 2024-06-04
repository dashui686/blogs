package com.dashui.blogs.web.admin;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dashui.blogs.bo.AdminBo;
import com.dashui.blogs.bo.AdminGroupBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.service.admin.AdminGroupService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 管理分组表(AdminGroup)表控制层
 *
 * @author makejava
 * @since 2024-06-04 22:03:30
 */
@RestController
@RequestMapping("auth.Group")
public class AdminGroupController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private AdminGroupService adminGroupService;

    /**
     * 分页查询所有数据
     *
     * @param adminGroupBo 分页对象
     * @param pageQuery 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(AdminGroupBo adminGroupBo, PageQuery pageQuery) {
        return success(adminGroupService.queryPage(adminGroupBo,pageQuery));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.adminGroupService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminGroup 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody AdminGroup adminGroup) {
        return success(this.adminGroupService.save(adminGroup));
    }

    /**
     * 修改数据
     *
     * @param adminGroup 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody AdminGroup adminGroup) {
        return success(this.adminGroupService.updateById(adminGroup));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.adminGroupService.removeByIds(idList));
    }
}

