package com.dashui.blogs.service.impl.admin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.bo.AdminGroupBo;
import com.dashui.blogs.common.core.constants.Constants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.service.GroupService;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.domain.AdminRule;
import com.dashui.blogs.mapper.admin.AdminRuleMapper;
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.mapper.admin.AdminGroupMapper;
import com.dashui.blogs.vo.AdminGroupInfoVo;
import com.dashui.blogs.vo.AdminGroupVo;
import io.github.linpeilie.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
* @author Administrator
* @description 针对表【admin_group(管理分组表)】的数据库操作Service实现
* @createDate 2024-05-21 15:27:44
*/
@Service
@RequiredArgsConstructor
public class AdminGroupServiceImpl extends ServiceImpl<AdminGroupMapper, AdminGroup>
    implements AdminGroupService, GroupService {

    private final AdminGroupMapper adminGroupMapper;

    private final AdminRuleMapper adminRuleMapper;
    private final Converter converter;

    /**
     * 根据管理员ID获取所属分组id
     * @param id 管理员id
     * @return 集合
     */
    @Override
    public List<Long> getAdminGroupIdsByAdminId(Long id) {
        return adminGroupMapper.getAdminGroupIdsByAdminId(id);
    }

    /**
     * 根据管理员ID获取所属分组名
     * @param id 管理员id
     * @return 集合
     */
    @Override
    public List<String> getAdminGroupNamesByAdminId(Long id) {
        return adminGroupMapper.getAdminGroupNamesByAdminId(id);

    }

    @Override
    public R selectTreeAll(AdminGroupBo adminGroupBo, PageQuery pageQuery) {
        List<AdminGroupVo> adminGroupVos = adminGroupMapper.selectVoList(this.buildQueryWrapper(adminGroupBo), AdminGroupVo.class);
        if(adminGroupBo.isTree()){
            return R.options(adminGroupVos);
        }else{
            return R.group(adminGroupVos.stream().filter(adminGroupVo -> adminGroupVo.getPid() == 0).map(AdminGroupVo::getId).collect(Collectors.toList()),buildOptions(adminGroupVos, 0));
        }
    }

    @Override
    public AdminGroupInfoVo queryVoById(Integer id) {
        return adminGroupMapper.selectVoById(id, AdminGroupInfoVo.class);
    }

    @Override
    public boolean saveEdit(AdminGroupInfoVo adminGroupInfoVo) {
        AdminGroup convert = converter.convert(adminGroupInfoVo, AdminGroup.class);
        return this.saveOrUpdate(convert);
    }

    private Wrapper<AdminGroup> buildQueryWrapper(AdminGroupBo adminGroupBo) {
        return new LambdaQueryWrapper<AdminGroup>().in(ObjectUtil.isNotNull(adminGroupBo.getInitValue()) && adminGroupBo.getInitValue().length > 0, AdminGroup::getId, CollUtil.toList(adminGroupBo.getInitValue()));
    }

    private List<AdminGroupVo> buildOptions(List<AdminGroupVo> adminGroupVos,Integer pid){
        // if(adminGroupVos.stream().allMatch(AdminGroupVo::getId,pid))

        List<AdminGroupVo> collect = adminGroupVos.stream().filter(adminGroupVo -> Objects.equals(adminGroupVo.getPid(), pid)).collect(Collectors.toList());
        if(CollUtil.isNotEmpty(collect)){
            collect.forEach(e->{
                List<AdminGroupVo> children = buildOptions(adminGroupVos, e.getId());
                e.setChildren(children);
                if(StringUtils.isNotEmpty(e.getRules())){
                    HashMap<String, Object> titleCount = adminRuleMapper.getTitleCount(e.getId());
                    if(CollUtil.isNotEmpty(titleCount) && e.getId() == 1){
                        e.setRules("超级管理员组");
                    }else{
                        e.setRules(titleCount.get("title")+"等 "+titleCount.get("count")+" 项");
                    }
                }
            });
        }
        return collect;
    }

    private void buildGroup(List<AdminGroupVo> adminGroupVos){

    }
}




