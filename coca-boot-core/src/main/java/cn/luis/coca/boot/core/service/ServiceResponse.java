package cn.luis.coca.boot.core.service;

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
public class ServiceResponse<T> implements Serializable {
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

    private ServiceResponse(Boolean success, ResponseIEnum responseCodeDesc, T data) {
        this.success = success;
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private ServiceResponse(Boolean success, String code, String desc, T data) {
        this.success = success;
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static ServiceResponse<Void> success() {
        return new ServiceResponse<>(Boolean.TRUE, ResponseIEnum.respOk(), null);
    }

    public static <T> ServiceResponse<T> success(T data) {
        return new ServiceResponse<>(Boolean.TRUE, ResponseIEnum.respOk(), data);
    }

    public static <T> ServiceResponse<T> success(T data, String message) {
        return new ServiceResponse<>(Boolean.TRUE, ResponseIEnum.respOk().getCode(), message, data);
    }

    public static <T> ServiceResponse<T> successMessage(String message) {
        return new ServiceResponse<>(Boolean.TRUE, ResponseIEnum.OK, message, null);
    }

    public static ServiceResponse<Void> errorMessage(String errorMessage) {
        return new ServiceResponse<>(Boolean.TRUE, ResponseIEnum.FAIL, errorMessage, null);
    }

    public static ServiceResponse<Void> errorMessage(ResponseIEnum responseCodeDesc) {
        return new ServiceResponse<>(Boolean.TRUE, responseCodeDesc, null);
    }
}
