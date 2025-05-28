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
public class WebResponse<T> implements Serializable {

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

    private WebResponse(boolean success, MessageTypeEnum messageTypeEnum, ResponseIEnum responseCodeDesc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private WebResponse(boolean success, MessageTypeEnum messageTypeEnum, String code, String desc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static WebResponse<Void> success() {
        return new WebResponse<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.ok(), null);
    }

    public static <T> WebResponse<T> success(T data) {
        return new WebResponse<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.ok(), data);
    }

    public static <T> WebResponse<T> success(T data, String message) {
        return new WebResponse<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.ok().getCode(), message, data);
    }

    public static WebResponse<Void> successMessage(String message) {
        return new WebResponse<>(true, MessageTypeEnum.SUCCESS, ResponseIEnum.ok().getCode(), message, null);
    }

    public static <T> WebResponse<T> warn(T data, String warnMessage) {
        return new WebResponse<>(true, MessageTypeEnum.WARN, ResponseIEnum.ok().getCode(), warnMessage, data);
    }

    public static WebResponse<Void> warnMessage(String warnMessage) {
        return new WebResponse<>(true, MessageTypeEnum.WARN, ResponseIEnum.ok().getCode(), warnMessage, null);
    }

    public static WebResponse<Void> errorMessage(String errorMessage) {
        return new WebResponse<>(false, MessageTypeEnum.ERROR, ResponseIEnum.fail().getCode(), errorMessage, null);
    }

    public static WebResponse<Void> error(ResponseIEnum responseCodeDesc) {
        return new WebResponse<>(false, MessageTypeEnum.ERROR, responseCodeDesc, null);
    }

    public static WebResponse<Void> error(BaseException baseException) {
        return new WebResponse<>(false, MessageTypeEnum.ERROR, baseException.getCode(), baseException.getDesc(), null);
    }

    public static WebResponse<Void> error(RuntimeException runtimeException) {
        return new WebResponse<>(false, MessageTypeEnum.ERROR, ResponseIEnum.fail().getCode(), runtimeException.getMessage(), null);
    }

    public static WebResponse<Void> ofState(Boolean state, String errorMessage) {
        return state ? success() : errorMessage(errorMessage);
    }

    public static WebResponse<Void> ofState(Boolean state, String errorMessage, String successMessage) {
        return state ? successMessage(successMessage) : errorMessage(errorMessage);
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