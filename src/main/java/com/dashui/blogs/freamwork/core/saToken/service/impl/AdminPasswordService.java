package com.dashui.blogs.freamwork.core.saToken.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dashui.blogs.domain.Admin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginBody;
import com.dashui.blogs.freamwork.core.saToken.enums.LoginType;
import com.dashui.blogs.freamwork.core.saToken.enums.UserStatus;
import com.dashui.blogs.freamwork.core.saToken.service.IAuthStrategy;
import com.dashui.blogs.freamwork.core.saToken.service.SysLoginService;
import com.dashui.blogs.freamwork.core.saToken.util.LoginHelper;
import com.dashui.blogs.freamwork.core.saToken.vo.LoginAdminVo;
import com.dashui.blogs.freamwork.exception.UserException;
import com.dashui.blogs.mapper.admin.AdminMapper;
import com.dashui.blogs.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static com.dashui.blogs.freamwork.core.saToken.service.IAuthStrategy.BASE_NAME;

/**
 * @Author Administrator$
 * @Date 2024/5/4$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.service.impl$
 * @ClassName: AdminPasswordService$
 * @Description: TODO
 * @Version 1.0
 */
@Service("passwordAdmin"+BASE_NAME)
@RequiredArgsConstructor
public class AdminPasswordService implements IAuthStrategy {

    // 验证码
    // private final CaptchaProperties captchaProperties;

    private final Logger log = LoggerFactory.getLogger(AdminPasswordService.class);

    private final SysLoginService loginService;
    private final AdminMapper adminMapper;

    @Override
    public LoginAdminVo login(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        String code = loginBody.getCode();
        String uuid = loginBody.getUuid();

        // boolean captchaEnabled = captchaProperties.getEnable();
        // 验证码开关
        // if (captchaEnabled) {
        //     validateCaptcha(tenantId, username, code, uuid);
        // }

        AdminVo adminVo = loadUserByUsername(username);
        loginService.checkLogin(LoginType.PASSWORD, username, () -> !BCrypt.checkpw(password,adminVo.getPassword()));
        // 此处可根据登录用户的数据不同 自行创建 loginUser
        LoginAdmin loginAdmin = loginService.buildLoginUser(adminVo);
        SaLoginModel model = new SaLoginModel();
        // 自定义分配 不同用户体系 不同 token 授权时间 不设置默认走全局 yml 配置
        // 例如: 后台用户30分钟过期 app用户1天过期
        // model.setTimeout(client.getTimeout());
        // model.setActiveTimeout(client.getActiveTimeout());
        // model.setExtra(LoginHelper.CLIENT_KEY, client.getClientId());
        // 生成token
        LoginHelper.login(loginAdmin, model);

        LoginAdminVo loginVo = new LoginAdminVo(adminVo);
        loginVo.setToken("Bearer "+StpUtil.getTokenValue());
        // loginVo.setExpireIn(StpUtil.getTokenTimeout());
        // loginVo.setClientId(client.getClientId());
        return loginVo;
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code     验证码
     * @param uuid     唯一标识
     */
    private void validateCaptcha(String tenantId, String username, String code, String uuid) {
        // String verifyKey = GlobalConstants.CAPTCHA_CODE_KEY + StringUtils.defaultString(uuid, "");
        // String captcha = RedisUtils.getCacheObject(verifyKey);
        // RedisUtils.deleteObject(verifyKey);
        // if (captcha == null) {
        //     loginService.recordLogininfor(tenantId, username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire"));
        //     throw new CaptchaExpireException();
        // }
        // if (!code.equalsIgnoreCase(captcha)) {
        //     loginService.recordLogininfor(tenantId, username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"));
        //     throw new CaptchaException();
        // }
    }

    private AdminVo loadUserByUsername(String username) {
        Admin admin = adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, username));
        if (ObjectUtil.isNull(admin)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UserException("user.not.exists", username);
        } else if (UserStatus.DISABLE.getCode().equals(admin.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new UserException("user.blocked", username);
        }
        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(admin,adminVo);
        return adminVo;
    }
}
