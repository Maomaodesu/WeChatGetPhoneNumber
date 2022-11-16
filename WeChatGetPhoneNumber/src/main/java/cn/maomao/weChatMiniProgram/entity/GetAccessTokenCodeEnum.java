package cn.maomao.weChatMiniProgram.entity;

import org.springframework.http.HttpStatus;

public enum GetAccessTokenCodeEnum {

    SystemBusy(-1,HttpStatus.BAD_REQUEST,"系统繁忙，此时请开发者稍候再试(GetAccessToken)"),
    Success(0,HttpStatus.OK,"请求成功"),
    WrongAppSecret(40001,HttpStatus.FORBIDDEN,"AppSecret 错误或者 AppSecret 不属于这个小程序，请开发者确认 AppSecret 的正确性"),
    WrongGrantType(40002,HttpStatus.FORBIDDEN,"请确保 grant_type 字段值为 client_credential"),
    WrongAppID(40013,HttpStatus.FORBIDDEN,"不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写");

    /**
     * 异常/错误码
     */
    private final Integer code;

    /**
     * Http状态
     */
    private final HttpStatus status;

    /**
     * 异常/错误信息
     */
    private final String message;

    GetAccessTokenCodeEnum(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
