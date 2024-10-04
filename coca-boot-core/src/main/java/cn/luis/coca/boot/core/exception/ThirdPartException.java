package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorCodeDescIEnum;
import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;

/**
 * 第三方异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class ThirdPartException extends BaseException {

    private static final long serialVersionUID = 7456374730637231241L;

    protected ThirdPartException(RuntimeException ex) {
        super(AliErrorCodeDescIEnum.SERVICE_ERROR_C0001, ex);
    }

    protected ThirdPartException(ResponseCodeDescIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected ThirdPartException(ResponseCodeDescIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}