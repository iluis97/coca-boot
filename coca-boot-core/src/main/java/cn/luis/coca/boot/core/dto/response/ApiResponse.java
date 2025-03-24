package cn.luis.coca.boot.core.dto.response;

import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;
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
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 5508412906173429839L;

    /**
     * 是否请求成功
     */
    private final Boolean success;

    /**
     * 消息类型, 其实放在这里并不灵活，应该放到data中，每条数据可能有不同类型
     * 目前仅标识返回的全部数据的类型
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

    private ApiResponse(boolean success, MessageTypeEnum messageTypeEnum, ResponseCodeDescIEnum responseCodeDesc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private ApiResponse(boolean success, MessageTypeEnum messageTypeEnum, String code, String desc, T data) {
        this.success = success;
        this.messageType = messageTypeEnum.getType();
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, MessageTypeEnum.SUCCESS, ResponseCodeDescIEnum.respOk(), null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, MessageTypeEnum.SUCCESS, ResponseCodeDescIEnum.respOk(), data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, MessageTypeEnum.SUCCESS, ResponseCodeDescIEnum.OK, message, data);
    }

    public static <T> ApiResponse<T> successMessage(String message) {
        return new ApiResponse<>(true, MessageTypeEnum.SUCCESS, ResponseCodeDescIEnum.OK, message, null);
    }

    public static <T> ApiResponse<T> warn(T data, String warnMessage) {
        return new ApiResponse<>(true, MessageTypeEnum.WARN, ResponseCodeDescIEnum.OK, warnMessage, data);
    }

    public static <T> ApiResponse<T> warnMessage(String warnMessage) {
        return new ApiResponse<>(true, MessageTypeEnum.WARN, ResponseCodeDescIEnum.OK, warnMessage, null);
    }

    public static ApiResponse<Void> errorMessage(String errorMessage) {
        return new ApiResponse<>(false, MessageTypeEnum.ERROR, ResponseCodeDescIEnum.FAIL, errorMessage, null);
    }

    public static ApiResponse<Void> error(ResponseCodeDescIEnum responseCodeDesc) {
        return new ApiResponse<>(false, MessageTypeEnum.ERROR, responseCodeDesc, null);
    }

    public static ApiResponse<Void> error(BaseException baseException) {
        return new ApiResponse<>(false, MessageTypeEnum.ERROR, baseException.getCode(), baseException.getDesc(), null);
    }

    public static ApiResponse<Void> error(RuntimeException runtimeException) {
        return new ApiResponse<>(false, MessageTypeEnum.ERROR, ResponseCodeDescIEnum.FAIL, runtimeException.getMessage(), null);
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