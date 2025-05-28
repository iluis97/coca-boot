package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;

/**
 * 系统异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
public class SystemException extends BaseException {

    private static final long serialVersionUID = -6462976541406465434L;

    public SystemException(ResponseIEnum responseCodeDesc) {
        super(responseCodeDesc);
    }

    public SystemException(ResponseIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }

    public SystemException(String message, ResponseIEnum responseCodeDesc) {
        super(message, responseCodeDesc);
    }

    public SystemException(String message, ResponseIEnum responseCodeDesc, Throwable cause) {
        super(message, responseCodeDesc, cause);
    }
}