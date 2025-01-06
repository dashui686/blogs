package com.dashui.blogs.web;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.bo.BlogBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.Blog;
import com.dashui.blogs.domain.BlogComment;
import com.dashui.blogs.domain.BlogContent;
import com.dashui.blogs.domain.SendEmailEntity;
import com.dashui.blogs.freamwork.config.SiteConfig;
import com.dashui.blogs.service.IndexService;
import com.dashui.blogs.service.blogs.BlogCommentService;
import com.dashui.blogs.service.blogs.BlogContentService;
import com.dashui.blogs.service.blogs.BlogService;
import com.dashui.blogs.vo.BlogVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Administrator$
 * @Date 2024/4/29$
 * @PackageName: com.dashui.blogs.web$
 * @ClassName: IndexController$
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("index")
@AllArgsConstructor
public class IndexController extends BaseController {

    private final SiteConfig siteConfig;

    private final BlogService blogService;

    private final BlogCommentService blogCommentService;

    private final BlogContentService blogContentService;

    private final IndexService indexService;

    /**
     * 获取所有博客
     */
    @GetMapping
    public R index(PageQuery pageQuery){
        Page<Blog> page = blogService.page(new Page<Blog>(1, 3), new QueryWrapper<Blog>().lambda().orderByDesc(Blog::getCreateTime));


        // List<Blogs> list = blogsService.selectPageBlogList(blogsDto,pageQuery);
        return success().data("blogs",page.getRecords());
    }


    /**
     * 主页配置
     * @return
     */
    @GetMapping("index")
    public R indexFrontend(){
        return R.success(new HashMap<String,Object>(){{
            // 打开会员中心
            put("openMemberCenter",true);
            // 菜单
            put("rules", Collections.emptyList());
            // 网站信息
            put("site",siteConfig);
            // 用户信息
            put("userInfo", Collections.emptyList());
            put("menus", Collections.emptyList());
        }});
    }



    /**
     * 联系我
     */
    @PostMapping("concat")
    public R senEmail(String name,String message, String email){
        if(StrUtil.isBlank(name)){
            return error("请输入您的姓名");
        }

        if(StrUtil.isBlank(message)){
            return error("请输入您的信息");
        }

        if(StrUtil.isBlank(email)){
            return error("请输入您的邮箱");
        }
        SendEmailEntity build = SendEmailEntity.SendEmailEntityBuilder.aSendEmailEntity()
                .withText(message)
                .withTo("1327674904@qq.com")
                .withFrom(email)
                .withSubject("有用户联系").build();
        return toAjax(indexService.sendEmail(build));
    }

    /**
     * 博客页
     * @return
     */
    @GetMapping("/blogs")
    public TableDataInfo<BlogVo> blogs(BlogBo blogBo,PageQuery pageQuery){
        Page<BlogVo> blogVoPage = blogService.selectPagePostList(blogBo, pageQuery);
        return TableDataInfo.build(blogVoPage);
    };

    /**
     * 博客详情
     * @param id 博客ID
     * @return
     */
    @GetMapping("/blog/{id}")
    public R blog(@PathVariable String id){
        // startPage();
        // List<Blog> list = blogsService.list(new QueryWrapper<Blog>().lambda().orderByDesc(Blog::getCreateTime));
        if (ObjectUtil.isNull(id)){
            return error("参数错误");
        }
        Blog byId = blogService.getById(id);

        List<BlogComment> list = blogCommentService.getTreeComment(new QueryWrapper<BlogComment>().lambda().eq(BlogComment::getBlogId, id));
        String content = blogContentService.getObj(Wrappers.lambdaQuery(BlogContent.class).
                eq(BlogContent::getBlogId, id)
                .select(BlogContent::getContent), Object::toString);
        return success()
                .data("blog",byId)
                .data("comments",list)
                .data("content",content)
                ;
    };


}
