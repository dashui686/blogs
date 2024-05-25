package com.dashui.blogs.freamwork.exception;

import com.dashui.blogs.common.core.exception.BaseException;

/**
 * @Author Administrator$
 * @Date 2024/5/8$
 * @PackageName: com.dashui.blogs.freamwork.exception$
 * @ClassName: UserException$
 * @Description: TODO
 * @Version 1.0
 */
public class UserException extends BaseException {

    public UserException() {
    }

    public UserException(String code, Object... args) {
        super("user", code, args, null);
    }
}
