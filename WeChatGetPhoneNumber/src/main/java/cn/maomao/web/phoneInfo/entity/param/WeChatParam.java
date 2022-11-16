package cn.maomao.web.phoneInfo.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatParam {

    /**
     * 动态令牌。可通过动态令牌换取用户手机号
     */
    @NonNull
    @ApiModelProperty(value = "动态令牌。可通过动态令牌换取用户手机号", required = true)
    private String code;

    /**
     * 微信登录时获取的code
     */
    @NonNull
    @ApiModelProperty(value = "微信登录时获取的code", required = true)
    private String jsCode;

}
