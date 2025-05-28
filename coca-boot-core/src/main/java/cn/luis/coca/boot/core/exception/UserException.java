package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

/**
 * 用户异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class UserException extends BizException {
    private static final long serialVersionUID = 7456374730637234141L;

    public UserException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    public UserException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }

    public UserException(String message, ResponseIEnum responseCodeDesc) {
        super(message, responseCodeDesc);
    }

    public UserException(String message, ResponseIEnum responseCodeDesc, Throwable cause) {
        super(message, responseCodeDesc, cause);
    }
}