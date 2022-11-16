package cn.maomao.weChatMiniProgram.entity;

import org.springframework.http.HttpStatus;

public enum GetPhoneNumberCodeEnum {

    SystemBusy(-1,HttpStatus.BAD_REQUEST,"系统繁忙，此时请开发者稍候再试(GetPhoneNumber)"),
    Success(0,HttpStatus.OK,"请求成功"),
    WrongCode(40029,HttpStatus.FORBIDDEN,"不合法的code(code不存在、已过期或者使用过)");

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

    GetPhoneNumberCodeEnum(Integer code, HttpStatus status, String message) {
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
