package cn.maomao.weChatMiniProgram.entity.param;

import lombok.Data;

@Data
public class WeChatMiniProgramParam {

    private String appId;

    private String appSecret;

    public WeChatMiniProgramParam(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

}
