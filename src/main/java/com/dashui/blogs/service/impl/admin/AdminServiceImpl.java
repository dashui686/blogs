package com.dashui.blogs.service.impl.admin;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.bo.AdminBo;
import com.dashui.blogs.common.core.constants.UserConstants;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.domain.AdminGroupAccess;
import com.dashui.blogs.service.AdminGroupAccessService;
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.service.admin.AdminService;
import com.dashui.blogs.mapper.admin.AdminMapper;
import com.dashui.blogs.vo.AdminVo;
import io.github.linpeilie.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Service实现
* @createDate 2024-05-01 00:19:56
*/
@Service
@AllArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    private final AdminMapper adminMapper;
    private final AdminGroupAccessService adminGroupAccessService;
    private final Converter converter;

    @Override
    public TableDataInfo<AdminVo> queryPage(AdminBo adminBo, PageQuery pageQuery) {
        IPage<AdminVo> adminVoIPage = adminMapper.selectPageAdminList(pageQuery.build(), this.buildQueryWrapper(adminBo));
        return TableDataInfo.build(adminVoIPage);
    }

    @Override
    public AdminVo queryVoById(Long id) {
        return adminMapper.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getId, id));
    }

    @Override
    @Transactional
    public boolean saveEdit(AdminVo admin) {
        Admin convert = converter.convert(admin, Admin.class);
        boolean b = this.saveOrUpdate(convert);
        // 添加完成后的操作
        if(b){
            adminGroupAccessService.remove(new LambdaQueryWrapper<AdminGroupAccess>().eq(AdminGroupAccess::getUid,admin.getId()));
            List<AdminGroupAccess> collected = admin.getGroupArr().stream().map(e -> {
                return new AdminGroupAccess(convert.getId(), e);
            }).collect(Collectors.toList());
            adminGroupAccessService.saveBatch(collected);
        }
        return b;
    }


    private Wrapper<Admin> buildQueryWrapper(AdminBo admin) {

        Map<String, Object> params = admin.getParams();
        LambdaQueryWrapper<Admin> adminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminLambdaQueryWrapper.eq(Admin::getDelFlag,UserConstants.NORMAL)

                .eq(ObjectUtil.isNotNull(admin.getId()),Admin::getId,admin.getId())
                .like(StringUtils.isNotBlank(admin.getUsername()),Admin::getUsername,admin.getUsername())
                .like(StringUtils.isNotBlank(admin.getNickname()),Admin::getNickname,admin.getNickname())
        ;
        return adminLambdaQueryWrapper;
    }
}




