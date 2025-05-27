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

    private static final ResponseIEnum BIZ_ERROR = ErrorMessage.errorOfMessage("业务异常!");

    protected BizException(RuntimeException ex) {
        super(BIZ_ERROR, ex);
    }

    protected BizException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected BizException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}