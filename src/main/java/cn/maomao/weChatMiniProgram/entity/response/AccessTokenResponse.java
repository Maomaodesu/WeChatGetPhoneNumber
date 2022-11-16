package cn.maomao.weChatMiniProgram.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.0
 * @description 调用微信getAccessToken接口返回值
 * @date 2022/7/3 16:17
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenResponse {

    /**
     * 获取到的凭证
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expires_in")
    private String expiresIn;

    /**
     * 错误码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errcode")
    private Integer errCode;

    /**
     * 错误信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errmsg")
    private String errMsg;
}
