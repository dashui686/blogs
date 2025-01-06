package com.dashui.blogs.service.impl.blogs;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogComment;
import com.dashui.blogs.service.blogs.BlogCommentService;
import com.dashui.blogs.mapper.blogs.BlogCommentMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【blog_comment(评论表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment>
    implements BlogCommentService{

    @Override
    public List<BlogComment> getTreeComment(LambdaQueryWrapper<BlogComment> queryWrapper){
        return buildTree(this.list(queryWrapper),0);
    }


    private List<BlogComment> buildTree(List<BlogComment> menus, Integer parentId){
        ArrayList<BlogComment> menuArrayList = CollUtil.newArrayList();
        // 判断是否为null或者空数组
        if (!ObjectUtil.isNull(menus) && CollectionUtil.isNotEmpty(menus)){
            // 循环节点
            for (BlogComment menu : menus) {
                // 判断是否是否等于需要查找的子节点
                if(Objects.equals(menu.getParentId(), parentId)){
                    if (hasChildren(menu, menus)) {
                        buildTree(menus,menu.getId());
                        menu.setChildren(menus.stream().filter(e -> e.getParentId().equals(menu.getId())).collect(Collectors.toList()));
                    }
                    menuArrayList.add(menu);
                }
            }
        }

        return menuArrayList;
    }


    private boolean hasChildren(BlogComment menu,List<BlogComment> menus){
        return CollectionUtil.isNotEmpty(menus.stream().filter(e -> e.getParentId().equals(menu.getId())).collect(Collectors.toList()));
    }
}




