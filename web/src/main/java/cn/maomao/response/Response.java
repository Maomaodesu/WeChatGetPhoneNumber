package cn.maomao.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
     * 返回数据
     */
    private Object data;

    public Response() {
    }

    public Response(@Nullable Object data) {
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
