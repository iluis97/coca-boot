package cn.luis.coca.boot.core.call;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 服务间调用通用入参
 *
 * @author Luis
 * @since 2025/05/27 9:29
 */
@Getter
public class Resp<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否请求成功, 不包含业务逻辑
     */
    private final Boolean success;

    /**
     * 消息code
     */
    private final String code;

    /**
     * 消息详情
     */
    private final String desc;

    /**
     * 返回的数据
     */
    private final T data;

    private Resp(Boolean success, ResponseIEnum responseCodeDesc, T data) {
        this.success = success;
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private Resp(Boolean success, String code, String desc, T data) {
        this.success = success;
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static <T> Resp<T> success() {
        return new Resp<>(Boolean.TRUE, ResponseIEnum.ok(), null);
    }

    public static <T> Resp<T> success(T data) {
        return new Resp<>(Boolean.TRUE, ResponseIEnum.ok(), data);
    }

    public static <T> Resp<T> success(T data, String message) {
        return new Resp<>(Boolean.TRUE, ResponseIEnum.ok().getCode(), message, data);
    }

    public static <T> Resp<T> successMessage(String message) {
        return new Resp<>(Boolean.TRUE, ResponseIEnum.ok().getCode(), message, null);
    }

    public static <T> Resp<T> errorMessage(String errorMessage) {
        return new Resp<>(Boolean.TRUE, ResponseIEnum.fail().getCode(), errorMessage, null);
    }

    public static <T> Resp<T> errorMessage(ResponseIEnum responseCodeDesc) {
        return new Resp<>(Boolean.TRUE, responseCodeDesc, null);
    }
}
