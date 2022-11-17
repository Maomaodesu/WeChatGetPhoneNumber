package cn.maomao.web.phoneInfo.controller;

import cn.maomao.response.Response;
import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoDTO;
import cn.maomao.web.phoneInfo.service.IPhoneInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Maomao
 * @version 1.0
 * @description 登录
 * @date 2022/2/11 17:46
 * @copyright 和平共科
 */
@RestController
@RequestMapping("/phoneInfo")
public class PhoneInfoController {

    @Autowired
    private IPhoneInfoService phoneInfoService;

    @PostMapping(value = "/getPhoneInfoByWeChatCode")
    public Response getPhoneInfoByWeChatCode(
            @RequestParam String weChatCode){
        PhoneInfoDTO phoneInfoDTO = phoneInfoService.getPhoneInfoByWeChatCode(weChatCode);
        return new Response(phoneInfoDTO);
    }
}
