package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorIEnum;
import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

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
        super(AliErrorIEnum.USER_ERROR_A0001, ex);
    }

    protected UserException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected UserException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}