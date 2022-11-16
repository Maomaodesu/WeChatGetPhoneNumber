package cn.maomao.weChatMiniProgram.entity.param;

import lombok.Data;

@Data
public class WeChatMiniProgramParam {

    private String appId = "wx3be14a7ec5e80dba";

    private String appSecret = "918ea50cc83a61545f1cb12706423936";

    public WeChatMiniProgramParam(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

}
