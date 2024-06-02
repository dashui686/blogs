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
import com.dashui.blogs.service.admin.AdminGroupService;
import com.dashui.blogs.service.admin.AdminService;
import com.dashui.blogs.mapper.admin.AdminMapper;
import com.dashui.blogs.vo.AdminVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    private final AdminGroupService adminGroupService;

    @Override
    public TableDataInfo<AdminVo> queryPage(AdminBo adminBo, PageQuery pageQuery) {
        IPage<AdminVo> adminVoIPage = adminMapper.selectPageAdminList(pageQuery.build(), this.buildQueryWrapper(adminBo));
        return TableDataInfo.build(adminVoIPage);
    }

    @Override
    public AdminVo queryVoById(Long id) {
        return adminMapper.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getId, id));
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




