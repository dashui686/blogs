package com.dashui.blogs.service.impl;

import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson2.util.DateUtils;
import com.dashui.blogs.domain.SendEmailEntity;
import com.dashui.blogs.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/23 13:33
 * @PackageName: com.dashui.naruto.service.impl
 * @ClassName: IndexServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {


    private  final  TemplateEngine templateEngine;

    @Override
    public boolean sendEmail(SendEmailEntity sendEmailEntity)  {
        Context context = new Context();
        //设置模板所需的参数
        context.setVariable("title","用户联系");
        context.setVariable("email",sendEmailEntity.getFrom());
        context.setVariable("text",sendEmailEntity.getText());
        context.setVariable("date", DateUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
        //通过模板类将动态参数传入HTML模板,并返回模板内容 参数一:模板名字，参数二：动态参数Web文本
        String content = templateEngine.process("emailContact",context);
        MailUtil.send(sendEmailEntity.getTo(), sendEmailEntity.getSubject(), content, true);
        return true;
    }

}
