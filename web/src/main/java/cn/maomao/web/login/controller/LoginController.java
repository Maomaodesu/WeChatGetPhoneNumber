package cn.maomao.web.login.controller;

import cn.maomao.response.Response;
import cn.maomao.weChatMiniProgram.entity.response.PhoneInfoResponseDTO;
import cn.maomao.web.login.entity.param.LoginByWeChatParam;
import cn.maomao.web.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Maomao
 * @version 1.0
 * @description 登录
 * @date 2022/2/11 17:46
 * @copyright 和平共科
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping(value = "/loginByWeChat")
    public Response loginByWeChat(
            @RequestBody LoginByWeChatParam loginByWeChatParam){
        PhoneInfoResponseDTO phoneInfoResponseDTO = loginService.loginByWeChat(loginByWeChatParam);
        return new Response(phoneInfoResponseDTO);
    }
}
