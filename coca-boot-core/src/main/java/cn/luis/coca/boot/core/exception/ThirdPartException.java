package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

/**
 * 第三方异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class ThirdPartException extends BaseException {

    private static final long serialVersionUID = 7456374730637231241L;

    public ThirdPartException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    public ThirdPartException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }

    public ThirdPartException(String message, ResponseIEnum responseCodeDesc) {
        super(message, responseCodeDesc);
    }

    public ThirdPartException(String message, ResponseIEnum responseCodeDesc, Throwable cause) {
        super(message, responseCodeDesc, cause);
    }
}