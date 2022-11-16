package cn.maomao.weChatMiniProgram.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.0
 * @description 微信用户信息
 * @date 2022/7/4 16:45
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionInfoResponseDTO {

    /**
     * 用户唯一标识
     */
    private String openId;

    /**
     * 会话密钥
     */
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    private String unionId;
}
