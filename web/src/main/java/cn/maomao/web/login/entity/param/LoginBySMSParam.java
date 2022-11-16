package cn.maomao.web.login.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBySMSParam {

    /**
     * 手机号
     */
    @NonNull
    @ApiModelProperty(value = "手机号", required = true)
    private String phoneNumber;

    /**
     * 短信验证码
     */
    @NonNull
    @ApiModelProperty(value = "短信验证码", required = true)
    private String verificationCode;

    /**
     * 微信登录时获取的code
     */
    @NonNull
    @ApiModelProperty(value = "微信登录时获取的code", required = true)
    private String jsCode;
}