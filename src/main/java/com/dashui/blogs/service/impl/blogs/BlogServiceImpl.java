package com.dashui.blogs.service.impl.blogs;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.bo.BlogBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.domain.Blog;
import com.dashui.blogs.service.blogs.BlogService;
import com.dashui.blogs.mapper.blogs.BlogMapper;
import com.dashui.blogs.vo.BlogVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【blog(博客表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
@AllArgsConstructor
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

    private final BlogMapper blogMapper;

    @Override
    public Page<BlogVo> selectPagePostList(BlogBo blogBo, PageQuery pageQuery){
         return blogMapper.selectVoPage(pageQuery.build(),buildQueryWrapper(blogBo));
    }


    /**
     * 根据查询条件构建查询包装器
     *
     * @param bo 查询条件对象
     * @return 构建好的查询包装器
     */
    private LambdaQueryWrapper<Blog> buildQueryWrapper(BlogBo bo) {
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Blog::getSort)
                .orderByDesc(Blog::getCreateTime);
        // if (ObjectUtil.isNotNull(bo.getDeptId())) {
        //     //优先单部门搜索
        //     wrapper.eq(Blog::getDeptId, bo.getDeptId());
        // } else if (ObjectUtil.isNotNull(bo.getBelongDeptId())) {
        //     //部门树搜索
        //     wrapper.and(x -> {
        //         List<Long> deptIds = deptMapper.selectList(new LambdaQueryWrapper<SysDept>()
        //                         .select(SysDept::getDeptId)
        //                         .apply(DataBaseHelper.findInSet(bo.getBelongDeptId(), "ancestors")))
        //                 .stream()
        //                 .map(SysDept::getDeptId)
        //                 .collect(Collectors.toList());
        //         deptIds.add(bo.getBelongDeptId());
        //         x.in(Blog::getDeptId, deptIds);
        //     });
        // }
        return wrapper;
    }

}




