package miss.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import miss.core.exception.CodeEnum;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Maomao
 * @version 1.0
 * @description 错误/异常码 + 错误/异常信息 + 数据 返回格式
 * @date 2021/8/30 18:36
 * @copyright 和平共科
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public Response(@NonNull CodeEnum codeEnum, @Nullable Object data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.data = data;
    }

    public Response(@NonNull CodeEnum codeEnum) {
        this(codeEnum, null);
    }

    public Response(String message) {
        this.message = message;
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
