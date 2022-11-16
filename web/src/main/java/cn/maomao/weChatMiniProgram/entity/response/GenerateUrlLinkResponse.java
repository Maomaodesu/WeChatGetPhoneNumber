package cn.maomao.weChatMiniProgram.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateUrlLinkResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errcode")
    private Integer errCode;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errmsg")
    private String errMsg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("url_link")
    private String urlLink;

}
