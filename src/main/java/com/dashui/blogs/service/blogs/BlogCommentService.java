package com.dashui.blogs.service.blogs;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dashui.blogs.domain.BlogComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【blog_comment(评论表)】的数据库操作Service
* @createDate 2025-01-04 04:07:24
*/
public interface BlogCommentService extends IService<BlogComment> {

    List<BlogComment> getTreeComment(LambdaQueryWrapper<BlogComment> queryWrapper);

}
