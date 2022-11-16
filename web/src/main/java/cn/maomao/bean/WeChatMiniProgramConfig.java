package cn.maomao.bean;

import cn.maomao.weChatMiniProgram.entity.param.WeChatMiniProgramParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeChatMiniProgramConfig {

    /**
     * app-id
     */
    @Value("${wechat-mini-program.app-id}")
    private String appId;

    /**
     * app-secret
     */
    @Value("${wechat-mini-program.app-secret}")
    private String appSecret;

    /**
     * 初始化微信小程序
     * @return
     */
    @Bean
    public WeChatMiniProgramParam initWeChatMiniProgramParam(){
        return new WeChatMiniProgramParam(
                appId,
                appSecret
        );
    }
}
