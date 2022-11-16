package cn.maomao.web.login.service;

import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoResponseDTO;
import cn.maomao.web.login.entity.param.LoginByWeChatParam;

/**
 * @author Maomao
 * @version 1.0
 * @description 注册和登录服务实现接口
 * @date 2022/2/11 17:49
 * @copyright 和平共科
 */
public interface ILoginService {

    /**
     * 微信授权登录
     * @param loginByWeChatParam
     * @return
     */
    PhoneInfoResponseDTO loginByWeChat(LoginByWeChatParam loginByWeChatParam);

}
