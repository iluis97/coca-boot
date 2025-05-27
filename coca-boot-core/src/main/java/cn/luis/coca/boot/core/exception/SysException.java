package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.AliErrorIEnum;
import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

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
        super(AliErrorIEnum.SYSTEM_ERROR_B0001, ex);
    }

    protected SysException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected SysException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}