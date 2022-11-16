package cn.maomao.weChatMiniProgram.publicManager;

import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoDTO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Maomao
 * @since 2021-08-29
 */
public interface IWeChatMiniProgramPublicManager {

    /**
     * 获取微信号绑定电话
     * @param code
     * @return
     */
    PhoneInfoDTO getWeChatPhoneInfo(String code);

}
