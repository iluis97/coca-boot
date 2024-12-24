package cn.luis.coca.boot.core.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ServiceResponse<T> extends BaseResponse<T> {

    protected Exception exception;

    private ServiceResponse(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private ServiceResponse(String errorMessage) {
        this.success = false;
        this.desc = errorMessage;
    }

    private ServiceResponse(Exception exception) {
        this.success = false;
        this.desc = Optional.ofNullable(exception).map(Exception::getMessage).orElse("系统异常");
        this.exception = exception;
    }


    public static <T> ServiceResponse<T> success(T data) {
        return new ServiceResponse<>(true, data);
    }

    public static <T> ServiceResponse<T> fail(String errorMessage) {
        return new ServiceResponse<>(errorMessage);
    }

    public static <T> ServiceResponse<T> failException(Exception failException) {
        return new ServiceResponse<>(failException);
    }


}
