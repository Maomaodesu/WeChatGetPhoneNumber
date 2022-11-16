package cn.maomao.weChatMiniProgram.entity.dataFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PhoneInfo {

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("purePhoneNumber")
    private String purePhoneNumber;

    /**
     * 区号
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("countryCode")
    private String countryCode;

    /**
     * 数据水印
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("watermark")
    private Watermark watermark;
}
