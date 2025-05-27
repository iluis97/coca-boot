package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorIEnum;
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

    protected ThirdPartException(RuntimeException ex) {
        super(AliErrorIEnum.SERVICE_ERROR_C0001, ex);
    }

    protected ThirdPartException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected ThirdPartException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}