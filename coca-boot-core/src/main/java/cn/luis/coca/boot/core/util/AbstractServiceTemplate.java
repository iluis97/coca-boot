package cn.luis.coca.boot.core.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractServiceTemplate<T> {

    /**
     * 是否请求成功
     */
    private Boolean success;

    /**
     * 捕获的异常
     */
    private Exception exception;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 检查
     */
    public void doCheck() {
        return;
    }

    /**
     * 执行前处理
     */
    public void doBefore() {
        return;
    }

    /**
     * 执行
     */
    public abstract void doExecute();

    /**
     * 执行后处理
     */
    public void doAfter() {
        return;
    }

    /**
     * 执行最终处理
     */
    public void doFinally() {
        return;
    }

    /**
     * 执行异常处理
     */
    public void doWhenException(){
        return;
    }

    /**
     * 执行最终异常处理
     */
    public void doWhenFinallyException(){
        return;
    }

    public void markSuccess(T data){
        this.success = Boolean.TRUE;
        this.data = data;
    }

    public void markFail(Exception failException){
        this.success = Boolean.FALSE;
        this.exception = failException;
    }

}
