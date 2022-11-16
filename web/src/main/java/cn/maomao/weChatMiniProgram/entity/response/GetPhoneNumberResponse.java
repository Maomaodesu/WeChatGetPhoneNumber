package cn.maomao.weChatMiniProgram.entity.response;

import cn.maomao.weChatMiniProgram.entity.dataFormat.PhoneInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maomao
 * @version 1.04
 * @description 微信phonenumber.getPhoneNumber方法返回格式
 * @date 2022/7/3 12:20
 * @copyright 和平共科
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPhoneNumberResponse {

    /**
     * 错误码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errcode")
    private Integer errCode;

    /**
     * 错误提示信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errmsg")
    private String errMsg;

    /**
     * 用户手机号信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("phone_info")
    private PhoneInfo phoneInfo;
}
