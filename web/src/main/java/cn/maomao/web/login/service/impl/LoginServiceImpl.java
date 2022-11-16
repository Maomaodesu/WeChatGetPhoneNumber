package cn.maomao.web.login.service.impl;

import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoResponseDTO;
import cn.maomao.weChatMiniProgram.publicManager.IWeChatMiniProgramPublicManager;
import cn.maomao.web.login.entity.param.LoginByWeChatParam;
import cn.maomao.web.login.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Maomao
 * @version 1.0
 * @description 注册和登录服务实现类
 * @date 2022/2/11 17:49
 * @copyright 和平共科
 */
@Service
public class LoginServiceImpl implements ILoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private IWeChatMiniProgramPublicManager weChatMiniProgramPublicManager;

    /**
     * 微信授权登录
     * @param loginByWeChatParam
     * @return
     */
    @Override
    public PhoneInfoResponseDTO loginByWeChat(LoginByWeChatParam loginByWeChatParam) {
        //向微信发送请求获取手机号码
        PhoneInfoResponseDTO phoneInfoResponseDTO = weChatMiniProgramPublicManager.getWeChatPhoneInfo(loginByWeChatParam.getCode());
        return phoneInfoResponseDTO;
    }

}
