package cn.luis.coca.boot.core.web;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;
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
    private final boolean success;

    /**
     * 消息类型
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

    public static <T> Response<T> warn(T data, String errorMessage) {
        return new Response<>(true, MessageTypeEnum.WARN, ResponseIEnum.OK, errorMessage, data);
    }

    public static Response<Void> warn(String errorMessage) {
        return new Response<>(true, MessageTypeEnum.WARN, ResponseIEnum.OK, errorMessage, null);
    }

    public static Response<Void> errorMessage(String errorMessage) {
        return new Response<>(false, MessageTypeEnum.ERROR, ResponseIEnum.FAIL, errorMessage, null);
    }

    public static Response<Void> errorMessage(ResponseIEnum responseCodeDesc) {
        return new Response<>(false, MessageTypeEnum.ERROR, responseCodeDesc, null);
    }

    @Getter
    @AllArgsConstructor
    private enum MessageTypeEnum {
        /**
         * 绿色
         */
        SUCCESS("success"),
        /**
         * 黄色
         */
        WARN("warn"),
        /**
         * 灰色
         */
        INFO("info"),
        /**
         * 红色
         */
        ERROR("error");

        private final String type;
    }

}