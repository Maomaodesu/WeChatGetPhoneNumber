package cn.maomao.weChatMiniProgram.entity.dataFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Watermark {

    /**
     * 用户获取手机号操作的时间戳
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("timestamp")
    private Double timestamp;

    /**
     * 小程序appid
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("appid")
    private String appId;
}
