package cn.maomao.web.phoneInfo.service.impl;

import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoDTO;
import cn.maomao.weChatMiniProgram.publicManager.IWeChatMiniProgramPublicManager;
import cn.maomao.web.phoneInfo.service.IPhoneInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Maomao
 * @version 1.0
 * @description 注册和登录服务实现类
 * @date 2022/2/11 17:49
 * @copyright 和平共科
 */
@Service
public class PhoneInfoServiceImpl implements IPhoneInfoService {

    private static final Logger log = LoggerFactory.getLogger(PhoneInfoServiceImpl.class);

    @Autowired
    private IWeChatMiniProgramPublicManager weChatMiniProgramPublicManager;

    /**
     * 微信授权登录
     * @param weChatCode
     * @return
     */
    @Override
    public PhoneInfoDTO getPhoneInfoByWeChatCode(String weChatCode) {
        //向微信发送请求获取手机号码
        return weChatMiniProgramPublicManager.getWeChatPhoneInfo(weChatCode);
    }

}
