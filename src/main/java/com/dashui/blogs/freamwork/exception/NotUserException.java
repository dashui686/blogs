package com.dashui.blogs.freamwork.exception;

import cn.dev33.satoken.exception.SaTokenException;

/**
 * 用户不存在异常
 * @Author Administrator$
 * @Date 2024/5/1$
 * @PackageName: com.dashui.blogs.freamwork.exception$
 * @ClassName: NotUserException$
 * @Description: TODO
 * @Version 1.0
 */
public class NotUserException extends SaTokenException {
    public NotUserException() {
        super("用户不存在");
    }
}
