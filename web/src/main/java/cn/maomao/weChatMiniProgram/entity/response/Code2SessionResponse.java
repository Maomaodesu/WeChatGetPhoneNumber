package cn.maomao.weChatMiniProgram.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.0
 * @description 调用微信code2Session接口返回值
 * @date 2022/7/3 16:20
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Code2SessionResponse {

    /**
     * 用户唯一标识
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("openid")
    private String openId;

    /**
     * 会话密钥
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("session_key")
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("unionid")
    private String unionId;

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
