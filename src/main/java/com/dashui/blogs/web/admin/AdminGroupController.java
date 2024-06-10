package com.dashui.blogs.web.admin;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dashui.blogs.bo.AdminBo;
import com.dashui.blogs.bo.AdminGroupBo;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.vo.AdminGroupInfoVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

/**
 * 管理分组表(AdminGroup)表控制层
 *
 * @author makejava
 * @since 2024-06-04 22:03:30
 */
@RestController
@RequestMapping(ADMIN_WEB_KEY+"/auth.Group")
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
    @GetMapping("/index")
    public AjaxResult selectTreeAll(AdminGroupBo adminGroupBo, PageQuery pageQuery) {
        return adminGroupService.selectTreeAll(adminGroupBo,pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("edit")
    public AjaxResult selectOne(Integer id) {
        return AjaxResult.success().data(Constants.DATA,this.adminGroupService.queryVoById(id));
    }

    /**
     * 新增数据
     *
     * @param adminGroupInfoVo 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public AjaxResult insert(@RequestBody AdminGroupInfoVo adminGroupInfoVo) {
        return success(this.adminGroupService.saveEdit(adminGroupInfoVo));
    }

    /**
     * 修改数据
     *
     * @param adminGroupInfoVo 实体对象
     * @return 修改结果
     */
    @PutMapping("edit")
    public AjaxResult update(@RequestBody AdminGroupInfoVo adminGroupInfoVo) {
        return success(this.adminGroupService.saveEdit(adminGroupInfoVo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("del")
    public AjaxResult delete(@RequestParam("ids[]") List<Long> idList) {
        return success(this.adminGroupService.removeByIds(idList));
    }
}

