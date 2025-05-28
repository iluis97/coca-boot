package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

/**
 * 业务异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 7456374730637231141L;

    public BizException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    public BizException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }

    public BizException(String message, ResponseIEnum responseCodeDesc) {
        super(message, responseCodeDesc);
    }

    public BizException(String message, ResponseIEnum responseCodeDesc, Throwable cause) {
        super(message, responseCodeDesc, cause);
    }
}