package com.dashui.blogs.freamwork.core.saToken.exception;

import com.dashui.blogs.common.core.exception.BaseException;

import java.io.Serial;

/**
 * @Author Administrator$
 * @Date 2024/5/19$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.exception$
 * @ClassName: UserException$
 * @Description: TODO
 * @Version 1.0
 */
public class UserException extends BaseException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object... args) {
        super("user", code, args, null);
    }
}
