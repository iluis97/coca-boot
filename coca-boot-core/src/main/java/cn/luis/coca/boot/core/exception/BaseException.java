package cn.luis.coca.boot.core.exception;

import cn.luis.coca.boot.core.enums.code.ResponseCodeDescIEnum;
import lombok.Getter;

/**
 * 基础自定义异常 [不引入具体的CodeDescEnum，只引入默认实现ErrorMessage] 不对外提供
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
@Getter
public abstract class BaseException extends RuntimeException implements ResponseCodeDescIEnum {

    private static final long serialVersionUID = -6462976541406465434L;

    protected final ResponseCodeDescIEnum responseCodeDesc;

    protected BaseException(RuntimeException ex) {
        super(ex.getMessage(), ex);
        this.responseCodeDesc = ResponseCodeDescIEnum.respFail();
    }

    protected BaseException(ResponseCodeDescIEnum responseCodeDesc) {
        super(responseCodeDesc.getDesc());
        this.responseCodeDesc = responseCodeDesc;
    }

    protected BaseException(ResponseCodeDescIEnum responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc.getDesc(), ex);
        this.responseCodeDesc = responseCodeDesc;
    }

    @Override
    public String getCode() {
        return this.responseCodeDesc.getCode();
    }

    @Override
    public String getDesc() {
        return this.responseCodeDesc.getDesc();
    }

}