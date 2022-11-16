package cn.maomao.weChatMiniProgram.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.0
 * @description 微信电话信息包
 * @date 2022/6/29 16:19
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneInfoDTO {

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;

    /**
     * 区号
     */
    private String countryCode;

    /**
     * 用户获取手机号操作的时间戳
     */
    private Double timestamp;

    /**
     * 小程序appid
     */
    private String appId;
}
