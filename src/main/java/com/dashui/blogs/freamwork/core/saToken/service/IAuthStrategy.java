package com.dashui.blogs.freamwork.core.saToken.service;

import com.dashui.blogs.common.utils.SpringUtils;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginBody;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.freamwork.exception.ServiceException;

/**
 * @Author Administrator$
 * @Date 2024/5/4$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.service$
 * @ClassName: IAuthService$
 * @Description: TODO
 * @Version 1.0
 */
public interface IAuthStrategy {

    String BASE_NAME = "AuthStrategy";

    /**
     * 登录
     */
    static LoginAdminVo login(LoginBody loginBody, String loginType) {
        IAuthStrategy instance = SpringUtils.getBean(IAuthStrategy.class);
        // return instance.login(body, client);
        return instance.login(loginBody);
    }

    /**
     * 登录
     */
    // LoginVo login(String body, SysClient client);
    LoginAdminVo login(LoginBody loginBody);
}
