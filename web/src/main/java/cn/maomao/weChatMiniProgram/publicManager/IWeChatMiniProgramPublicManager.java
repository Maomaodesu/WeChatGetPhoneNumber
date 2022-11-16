package cn.maomao.weChatMiniProgram.publicManager;

import cn.maomao.weChatMiniProgram.entity.response.AccessTokenInfoResponseDTO;
import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoResponseDTO;
import cn.maomao.weChatMiniProgram.entity.response.SessionInfoResponseDTO;


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
     * 获取AccessTokenInfo
     * @return
     */
    AccessTokenInfoResponseDTO getAccessTokenInfo();

    /**
     * 获取微信号绑定电话
     * @param code
     * @return
     */
    PhoneInfoResponseDTO getWeChatPhoneInfo(String code);

}
