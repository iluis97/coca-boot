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
    public static ThirdPartException thirdPartException(RuntimeException ex) {
        return new ThirdPartException(ex);
    }

    public static ThirdPartException thirdPartException(String message) {
        return new ThirdPartException(ErrorMessage.errorOfMessage(message));
    }

    public static ThirdPartException thirdPartException(String message, RuntimeException ex) {
        return new ThirdPartException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static ThirdPartException thirdPartException(ResponseIEnum responseCodeDesc) {
        return new ThirdPartException(responseCodeDesc);
    }

    public static ThirdPartException thirdPartException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new ThirdPartException(responseCodeDesc, ex);
    }

    /**
     * userException
     */
    public static UserException userException(RuntimeException ex) {
        return new UserException(ex);
    }

    public static UserException userException(String message) {
        return new UserException(ErrorMessage.errorOfMessage(message));
    }

    public static UserException userException(String message, RuntimeException ex) {
        return new UserException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static UserException userException(ResponseIEnum responseCodeDesc) {
        return new UserException(responseCodeDesc);
    }

    public static UserException userException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new UserException(responseCodeDesc, ex);
    }


    /**
     * bizException
     */
    public static BizException bizException(RuntimeException ex) {
        return new BizException(ex);
    }

    public static BizException bizException(String message) {
        return new BizException(ErrorMessage.errorOfMessage(message));
    }

    public static BizException bizException(String message, RuntimeException ex) {
        return new BizException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static BizException bizException(ResponseIEnum responseCodeDesc) {
        return new BizException(responseCodeDesc);
    }

    public static BizException bizException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new BizException(responseCodeDesc, ex);
    }

    /**
     * sysException
     */
    public static SysException sysException(RuntimeException ex) {
        return new SysException(ex);
    }

    public static SysException sysException(String message) {
        return new SysException(ErrorMessage.errorOfMessage(message));
    }

    public static SysException sysException(String message, RuntimeException ex) {
        return new SysException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static SysException sysException(ResponseIEnum responseCodeDesc) {
        return new SysException(responseCodeDesc);
    }

    public static SysException sysException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        return new SysException(responseCodeDesc, ex);
    }

}