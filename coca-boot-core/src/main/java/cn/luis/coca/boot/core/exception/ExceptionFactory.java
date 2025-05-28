package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

/**
 * 异常工厂实现、统一管理
 *
 * @author luis
 * @since 1.0
 * created 2022/5/28 12:03
 */
public class ExceptionFactory {

    /**
     * thirdPartException
     */
    public static ThirdPartException thirdPartException(ResponseIEnum responseCodeDesc) {
        return new ThirdPartException(responseCodeDesc);
    }

    public static ThirdPartException thirdPartException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new ThirdPartException(responseCodeDesc, ex);
    }

    public static ThirdPartException thirdPartException(String message) {
        return new ThirdPartException(ErrorMessage.errorOfMessage(message));
    }

    public static ThirdPartException thirdPartException(String message, ResponseIEnum responseCodeDesc) {
        return new ThirdPartException(message, responseCodeDesc);
    }

    public static ThirdPartException thirdPartException(String message, ResponseIEnum responseCodeDesc, Throwable cause) {
        return new ThirdPartException(message, responseCodeDesc, cause);
    }

    /*
     * --------------------------------------------------------------------------------------
     */

    /**
     * bizException
     */
    public static BizException BizException(ResponseIEnum responseCodeDesc) {
        return new BizException(responseCodeDesc);
    }

    public static BizException BizException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new BizException(responseCodeDesc, ex);
    }

    public static BizException BizException(String message) {
        return new BizException(ErrorMessage.errorOfMessage(message));
    }

    public static BizException BizException(String message, ResponseIEnum responseCodeDesc) {
        return new BizException(message, responseCodeDesc);
    }

    /**
     * userException
     */
    public static UserException UserException(ResponseIEnum responseCodeDesc) {
        return new UserException(responseCodeDesc);
    }

    public static UserException UserException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new UserException(responseCodeDesc, ex);
    }

    public static UserException UserException(String message) {
        return new UserException(ErrorMessage.errorOfMessage(message));
    }

    public static UserException UserException(String message, ResponseIEnum responseCodeDesc) {
        return new UserException(message, responseCodeDesc);
    }

    /*
     * --------------------------------------------------------------------------------------
     */

    /**
     * sysException
     */
    public static SystemException SystemException(ResponseIEnum responseCodeDesc) {
        return new SystemException(responseCodeDesc);
    }

    public static SystemException SystemException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new SystemException(responseCodeDesc, ex);
    }

    public static SystemException SystemException(String message) {
        return new SystemException(ErrorMessage.errorOfMessage(message));
    }

    public static SystemException SystemException(String message, ResponseIEnum responseCodeDesc) {
        return new SystemException(message, responseCodeDesc);
    }

}