package cn.maomao.weChatMiniProgram.entity;

import org.springframework.http.HttpStatus;

public enum Code2SessionCodeEnum {

    SystemBusy(-1,HttpStatus.BAD_REQUEST,"系统繁忙，此时请开发者稍候再试(Code2Session)"),
    Success(0,HttpStatus.OK,"请求成功"),
    WrongJsCode(40029,HttpStatus.FORBIDDEN,"jsCode无效"),
    WrongGrantType(45011,HttpStatus.FORBIDDEN,"频率限制，每个用户每分钟100次"),
    HighRiskUser(40226,HttpStatus.FORBIDDEN,"高风险等级用户，小程序登录拦截");

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

    Code2SessionCodeEnum(Integer code, HttpStatus status, String message) {
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
