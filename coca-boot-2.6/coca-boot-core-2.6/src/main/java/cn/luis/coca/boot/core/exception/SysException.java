package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorCodeDescIEnum;
import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;

/**
 * 系统异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = -6462976541406465434L;

    protected SysException(RuntimeException ex) {
        super(AliErrorCodeDescIEnum.SYSTEM_ERROR_B0001, ex);
    }

    protected SysException(ResponseCodeDescIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected SysException(ResponseCodeDescIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}