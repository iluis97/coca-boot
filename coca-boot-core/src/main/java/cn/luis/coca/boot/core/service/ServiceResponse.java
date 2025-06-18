package cn.luis.coca.boot.core.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
public class ServiceResponse<T> implements Serializable {

    /**
     * 消息类型
     */
    protected Boolean success;

    /**
     * 消息详情
     */
    protected String desc;

    /**
     * 返回的数据
     */
    protected T data;

    /**
     * 异常
     */
    protected Throwable throwable;

    private ServiceResponse(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private ServiceResponse(String errorMessage) {
        this.success = false;
        this.desc = errorMessage;
    }

    private ServiceResponse(Throwable throwable) {
        this.success = false;
        this.desc = Optional.ofNullable(throwable).map(Throwable::getMessage).orElse("服务调用异常");
        this.throwable = throwable;
    }

    public static <T> ServiceResponse<T> success(T data) {
        return new ServiceResponse<>(true, data);
    }

    public static <T> ServiceResponse<T> fail(String errorMessage) {
        return new ServiceResponse<>(errorMessage);
    }

    public static <T> ServiceResponse<T> failException(Throwable throwable) {
        return new ServiceResponse<>(throwable);
    }


}
