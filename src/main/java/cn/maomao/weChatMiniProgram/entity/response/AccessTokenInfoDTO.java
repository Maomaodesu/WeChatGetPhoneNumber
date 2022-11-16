package cn.maomao.weChatMiniProgram.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.0
 * @description 微信Accession相关信息
 * @date 2022/7/4 16:10
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenInfoDTO {

    /**
     * 获取到的凭证
     */
    private String accessToken;

    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值。
     */
    private String expiresIn;
}
