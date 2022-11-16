package cn.maomao.weChatMiniProgram.publicManager.impl;

import cn.maomao.weChatMiniProgram.entity.GetAccessTokenCodeEnum;
import cn.maomao.weChatMiniProgram.entity.GetPhoneNumberCodeEnum;
import cn.maomao.weChatMiniProgram.entity.param.WeChatMiniProgramParam;
import cn.maomao.weChatMiniProgram.entity.response.*;
import cn.maomao.weChatMiniProgram.publicManager.IWeChatMiniProgramPublicManager;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Maomao
 * @since 2021-08-29
 */
@Service
public class WeChatMiniProgramPublicManagerImpl implements IWeChatMiniProgramPublicManager {

    private static final Logger log = LoggerFactory.getLogger(WeChatMiniProgramPublicManagerImpl.class);

    @Autowired
    private WeChatMiniProgramParam weChatMiniProgramParam;

    /**
     * 获取微信号绑定电话
     * @param code
     * @return
     */
    @Override
    public PhoneInfoDTO getWeChatPhoneInfo(String code){
        AccessTokenInfoDTO accessTokenInfoDTO = getAccessTokenInfo();
        PhoneNumberResponse phoneNumberResponse = null;
        phoneNumberResponse = getPhoneNumber(accessTokenInfoDTO.getAccessToken(), code);
        if(phoneNumberResponse.getErrCode() == null || Objects.equals(phoneNumberResponse.getErrCode(), GetPhoneNumberCodeEnum.Success.getCode())){
            return new PhoneInfoDTO(
                    phoneNumberResponse.getPhoneInfo().getPhoneNumber(),
                    phoneNumberResponse.getPhoneInfo().getPurePhoneNumber(),
                    phoneNumberResponse.getPhoneInfo().getCountryCode(),
                    phoneNumberResponse.getPhoneInfo().getWatermark().getTimestamp(),
                    phoneNumberResponse.getPhoneInfo().getWatermark().getAppId());
        }else {
            if(GetPhoneNumberCodeEnum.SystemBusy.getCode().equals(phoneNumberResponse.getErrCode())){
                log.info(GetPhoneNumberCodeEnum.SystemBusy.getMessage());
            }else if(GetPhoneNumberCodeEnum.WrongCode.getCode().equals(phoneNumberResponse.getErrCode())){
                log.info(GetPhoneNumberCodeEnum.WrongCode.getMessage());
            }
            throw new RuntimeException();
        }
    }
    /**
     * 获取AccessTokenInfo
     * @return
     */
    private AccessTokenInfoDTO getAccessTokenInfo(){
        AccessTokenResponse accessTokenResponse = null;
        try {
            accessTokenResponse = getAccessToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(accessTokenResponse.getErrCode() == null || Objects.equals(accessTokenResponse.getErrCode(), GetAccessTokenCodeEnum.Success.getCode())){
            return new AccessTokenInfoDTO(
                    accessTokenResponse.getAccessToken(),
                    accessTokenResponse.getExpiresIn()
            );
        }else {
            if (accessTokenResponse.getErrCode().equals(GetAccessTokenCodeEnum.SystemBusy.getCode())) {
                log.info(GetAccessTokenCodeEnum.SystemBusy.getMessage());
            } else if (accessTokenResponse.getErrCode().equals(GetAccessTokenCodeEnum.WrongAppSecret.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongAppSecret.getMessage());
            } else if (accessTokenResponse.getErrCode().equals(GetAccessTokenCodeEnum.WrongGrantType.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongGrantType.getMessage());
            } else if (accessTokenResponse.getErrCode().equals(GetAccessTokenCodeEnum.WrongAppID.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongAppID.getMessage());
            }
            throw new RuntimeException();
        }
    }
    /**
     * 调用微信auth.getAccessToken
     */
    public AccessTokenResponse getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
                        +"&appid=" + weChatMiniProgramParam.getAppId()
                        +"&secret=" + weChatMiniProgramParam.getAppSecret())
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseBodyJson = response.body().string();
            AccessTokenResponse accessTokenResponse = mapper.readValue(responseBodyJson, AccessTokenResponse.class);
            return accessTokenResponse;
        }
    }

    /**
     * 调用微信phonenumber.getPhoneNumber
     * @param accessToken
     * @param code
     * @return
     */
    public PhoneNumberResponse getPhoneNumber(String accessToken, String code) {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        JSONObject json = new JSONObject();
        json.put("code", code);
        RequestBody body = RequestBody.create(JSON, String.valueOf(json));
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token="+accessToken)
                .post(body)
                .build();
        PhoneNumberResponse phoneNumberResponse = null;
        try {
            Response response = client.newCall(request).execute();
            String responseBodyJson = response.body().string();
            phoneNumberResponse = mapper.readValue(responseBodyJson, PhoneNumberResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phoneNumberResponse;
    }

}
