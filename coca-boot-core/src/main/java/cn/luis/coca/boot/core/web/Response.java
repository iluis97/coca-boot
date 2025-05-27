package cn.luis.coca.boot.core.web;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;
import cn.luis.coca.boot.core.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 前端返回值
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 8:59
 */
@Getter
@ToString
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5508412906173429839L;

    /**
     * 是否请求成功
     */
    private final Boolean success;

    /**
     * 消息类型
     *
     * @see MessageTypeEnum
     */
    private final String messageType;

    /**
     * 消息code
     */
    private final String code;

    /**
     * 消息详情
     */
    private final String desc;

    /**
     * 返回前端的数据
     */
    private final T data;

    private Response(boolean success, MessageTypeEnum messageTypeEnum, ResponseIEnum responseCodeDesc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private Response(boolean success, MessageTypeEnum messageTypeEnum, String code, String desc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static Response<Void> success() {
        return new Response<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.respOk(), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.respOk(), data);
    }

    public static <T> Response<T> success(T data, String message) {
        return new Response<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.OK, message, data);
    }

    public static Response<Void> successMessage(String message) {
        return new Response<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.OK, message, null);
    }

    public static <T> Response<T> warn(T data, String warnMessage) {
        return new Response<>(true, MessageTypeEnum.WARN, ResponseIEnum.OK, warnMessage, data);
    }

    public static Response<Void> warnMessage(String warnMessage) {
        return new Response<>(true, MessageTypeEnum.WARN, ResponseIEnum.OK, warnMessage, null);
    }

    public static Response<Void> errorMessage(String errorMessage) {
        return new Response<>(false, MessageTypeEnum.ERROR, ResponseIEnum.FAIL, errorMessage, null);
    }

    public static Response<Void> error(ResponseIEnum responseCodeDesc) {
        return new Response<>(false, MessageTypeEnum.ERROR, responseCodeDesc, null);
    }

    public static Response<Void> error(BaseException baseException) {
        return new Response<>(false, MessageTypeEnum.ERROR, baseException.getCode(), baseException.getDesc(), null);
    }

    public static Response<Void> error(RuntimeException runtimeException) {
        return new Response<>(false, MessageTypeEnum.ERROR, ResponseIEnum.FAIL, runtimeException.getMessage(), null);
    }

    @Getter
    @AllArgsConstructor
    private enum MessageTypeEnum {
        /**
         * 成功, 绿色
         */
        SUCCESS("success"),
        /**
         * 警告, 黄色
         */
        WARN("warn"),
        /**
         * 提示, 灰色
         */
        INFO("info"),
        /**
         * 异常, 红色
         */
        ERROR("error");

        private final String type;
    }

}