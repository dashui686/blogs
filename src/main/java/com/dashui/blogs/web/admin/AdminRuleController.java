package com.dashui.blogs.web.admin;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.bo.AdminRuleBo;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.AdminRule;
import com.dashui.blogs.dto.AdminRuleDto;
import com.dashui.blogs.service.admin.AdminRuleService;
import com.dashui.blogs.vo.AdminRuleVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.dashui.blogs.common.core.constants.WebConstants.ADMIN_WEB_KEY;

/**
 * 菜单和权限规则表(AdminRule)表控制层
 *
 * @author makejava
 * @since 2024-06-09 04:46:58
 */
@RestController
@RequestMapping(ADMIN_WEB_KEY+"/auth.Rule")
public class AdminRuleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private AdminRuleService adminRuleService;

    /**
     * 分页查询所有数据
     *
     * @param adminRuleBo 分页对象
     * @param pageQuery 查询实体
     * @return 所有数据
     */
    @GetMapping("/index")
    public TableDataInfo<AdminRuleVo> selectAll(AdminRuleBo adminRuleBo, PageQuery pageQuery) {
        return this.adminRuleService.selectPageVo(adminRuleBo,pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("edit")
    public AjaxResult selectOne(@RequestParam Serializable id) {
        // return AjaxResult.success().data(Constants.DATA,this.adminRuleService.queryVoById(id));

        return AjaxResult.row(this.adminRuleService.getVoById(id));
    }

    /**
     * 新增数据
     *
     * @param adminRuleDto 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public AjaxResult insert(@RequestBody AdminRuleDto adminRuleDto) {
        boolean save = this.adminRuleService.add(adminRuleDto);
        return toAjax(true);
    }

    /**
     * 修改数据
     *
     * @param adminRuleDto 实体对象
     * @return 修改结果
     */
    @PostMapping("edit")
    public AjaxResult update(@RequestBody AdminRuleDto adminRuleDto) {
        return toAjax(this.adminRuleService.saveEdit(adminRuleDto));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("del")
    public AjaxResult delete(@RequestParam("ids[]") List<Long> idList) {
        return AjaxResult.success(this.adminRuleService.removeByIds(idList));
    }
}

