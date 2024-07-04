package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;

/**
 * 业务异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 7456374730637231141L;

    private static final ResponseCodeDescIEnum BIZ_ERROR = ErrorMessage.errorOfMessage("业务异常!");

    protected BizException(RuntimeException ex) {
        super(BIZ_ERROR, ex);
    }

    protected BizException(ResponseCodeDescIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected BizException(ResponseCodeDescIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}