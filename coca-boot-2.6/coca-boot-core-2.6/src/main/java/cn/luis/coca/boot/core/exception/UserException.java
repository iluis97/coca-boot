package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorCodeDescIEnum;
import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;

/**
 * 用户异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 7456374730637234141L;

    protected UserException(RuntimeException ex) {
        super(AliErrorCodeDescIEnum.USER_ERROR_A0001, ex);
    }

    protected UserException(ResponseCodeDescIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected UserException(ResponseCodeDescIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}