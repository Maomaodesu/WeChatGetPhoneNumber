package cn.maomao.weChatMiniProgram.publicManager.impl;

import cn.maomao.weChatMiniProgram.entity.Code2SessionCodeEnum;
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
     * 获取AccessTokenInfo
     * @return
     */
    @Override
    public AccessTokenInfoResponseDTO getAccessTokenInfo(){
        GetAccessTokenResponse accessTokenResult = null;
        try {
            accessTokenResult = getAccessToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(accessTokenResult.getErrCode() == null || Objects.equals(accessTokenResult.getErrCode(), GetAccessTokenCodeEnum.Success.getCode())){
            return new AccessTokenInfoResponseDTO(
                    accessTokenResult.getAccessToken(),
                    accessTokenResult.getExpiresIn()
            );
        }else {
            if (accessTokenResult.getErrCode().equals(GetAccessTokenCodeEnum.SystemBusy.getCode())) {
                log.info(GetAccessTokenCodeEnum.SystemBusy.getMessage());
            } else if (accessTokenResult.getErrCode().equals(GetAccessTokenCodeEnum.WrongAppSecret.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongAppSecret.getMessage());
            } else if (accessTokenResult.getErrCode().equals(GetAccessTokenCodeEnum.WrongGrantType.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongGrantType.getMessage());
            } else if (accessTokenResult.getErrCode().equals(GetAccessTokenCodeEnum.WrongAppID.getCode())) {
                log.info(GetAccessTokenCodeEnum.WrongAppID.getMessage());
            }
            throw new RuntimeException();
        }
    }
    /**
     * 调用微信auth.getAccessToken
     */
    public GetAccessTokenResponse getAccessToken() throws IOException {
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
            GetAccessTokenResponse getAccessTokenResponse = mapper.readValue(responseBodyJson, GetAccessTokenResponse.class);
            return getAccessTokenResponse;
        }
    }

    /**
     * 获取微信号绑定电话
     * @param code
     * @return
     */
    @Override
    public PhoneInfoResponseDTO getWeChatPhoneInfo(String code){
        AccessTokenInfoResponseDTO accessTokenInfo = getAccessTokenInfo();
        GetPhoneNumberResponse phoneNumberResult = null;
        phoneNumberResult = getPhoneNumber(accessTokenInfo.getAccessToken(), code);
        if(phoneNumberResult.getErrCode() == null || Objects.equals(phoneNumberResult.getErrCode(), GetPhoneNumberCodeEnum.Success.getCode())){
            return new PhoneInfoResponseDTO(
                    phoneNumberResult.getPhoneInfo().getPhoneNumber(),
                    phoneNumberResult.getPhoneInfo().getPurePhoneNumber(),
                    phoneNumberResult.getPhoneInfo().getCountryCode(),
                    phoneNumberResult.getPhoneInfo().getWatermark().getTimestamp(),
                    phoneNumberResult.getPhoneInfo().getWatermark().getAppId());
        }else {
            if(GetPhoneNumberCodeEnum.SystemBusy.getCode().equals(phoneNumberResult.getErrCode())){
                log.info(GetPhoneNumberCodeEnum.SystemBusy.getMessage());
            }else if(GetPhoneNumberCodeEnum.WrongCode.getCode().equals(phoneNumberResult.getErrCode())){
                log.info(GetPhoneNumberCodeEnum.WrongCode.getMessage());
            }
            throw new RuntimeException();
        }
    }

    /**
     * 调用微信phonenumber.getPhoneNumber
     * @param accessToken
     * @param code
     * @return
     */
    public GetPhoneNumberResponse getPhoneNumber(String accessToken, String code) {
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
        GetPhoneNumberResponse getPhoneNumberResponse = null;
        try {
            Response response = client.newCall(request).execute();
            String responseBodyJson = response.body().string();
            getPhoneNumberResponse = mapper.readValue(responseBodyJson, GetPhoneNumberResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getPhoneNumberResponse;
    }



}
