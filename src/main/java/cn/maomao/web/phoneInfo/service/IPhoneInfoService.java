package cn.maomao.web.phoneInfo.service;

import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoDTO;

/**
 * @author Maomao
 * @version 1.0
 * @description 注册和登录服务实现接口
 * @date 2022/2/11 17:49
 * @copyright 和平共科
 */
public interface IPhoneInfoService {

    /**
     * 微信授权登录
     * @param weChatCode
     * @return
     */
    PhoneInfoDTO getPhoneInfoByWeChatCode(String weChatCode);

}
