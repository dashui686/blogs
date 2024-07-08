package com.dashui.blogs.service.impl.blogs;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogsComments;
import com.dashui.blogs.mapper.blogs.BlogsCommentsMapper;
import com.dashui.blogs.service.blogs.BlogsCommentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【blogs_comments(评论表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsCommentsServiceImpl extends ServiceImpl<BlogsCommentsMapper, BlogsComments>
    implements BlogsCommentsService {

    @Override
    public List<BlogsComments> getTreeComments(LambdaQueryWrapper<BlogsComments> queryWrapper){
        return buildTree(this.list(queryWrapper),0);
    }


    private List<BlogsComments> buildTree(List<BlogsComments> menus, Integer parentId){
        ArrayList<BlogsComments> menuArrayList = CollUtil.newArrayList();
        // 判断是否为null或者空数组
        if (!ObjectUtil.isNull(menus) && CollectionUtil.isNotEmpty(menus)){
            // 循环节点
            for (BlogsComments menu : menus) {
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


    private boolean hasChildren(BlogsComments menu,List<BlogsComments> menus){
        return CollectionUtil.isNotEmpty(menus.stream().filter(e -> e.getParentId().equals(menu.getId())).collect(Collectors.toList()));
    }

}




