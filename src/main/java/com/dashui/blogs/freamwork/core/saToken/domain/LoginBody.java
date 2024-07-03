package com.dashui.blogs.freamwork.core.saToken.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户登录对象
 *
 * @author Lion Li
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginBody implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户端id
     */
    // 可以防止token冒用
    // @NotBlank(message = "{auth.clientid.not.blank}")
    // private String clientId;

    /**
     * 授权类型
     */
    @NotBlank(message = "{auth.grant.type.not.blank}")
    private String grantType;

    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 验证码ID
     */
    private String captchaId;

    /**
     * 验证码信息
     */
    private String captchaInfo;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid;

    private boolean keep;

}
