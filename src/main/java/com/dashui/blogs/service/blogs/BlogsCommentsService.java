package com.dashui.blogs.service.blogs;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.domain.BlogsComments;

import java.util.List;

/**
* @author Administrator
* @description 针对表【blogs_comments(评论表)】的数据库操作Service
* @createDate 2023-04-16 13:08:20
*/
public interface BlogsCommentsService extends IService<BlogsComments> {

    List<BlogsComments> getTreeComments(LambdaQueryWrapper<BlogsComments> queryWrapper);
}
