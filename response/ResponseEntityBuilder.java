package miss.core.response;

import miss.core.exception.CodeEnum;
import org.springframework.http.ResponseEntity;

/**
 * @author Maomao
 * @version 1.0
 * @description ResponseEntity返回格式构造类
 * @date 2021/8/30 18:36
 * @copyright 和平共科
 */
public class ResponseEntityBuilder {

    /**
     * 返回码枚举
     */
    private final CodeEnum codeEnum;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 设置返回码
     * @param codeEnum
     * @return
     */
    public static ResponseEntityBuilder setCode(CodeEnum codeEnum) {
        return new ResponseEntityBuilder(codeEnum);
    }

    /**
     * 仅包括返回码的构造函数
     * @param codeEnum
     */
    private ResponseEntityBuilder(CodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }

    /**
     * 设置数据对象
     * @param data
     * @return
     */
    public ResponseEntityBuilder setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 创建返回类
     * @return
     */
    public ResponseEntity<Response> build() {
        return ResponseEntity
                .status(codeEnum.getStatus())
                .body(new Response(codeEnum, data));
    }


}
