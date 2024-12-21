package cn.luis.coca.boot.core.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class AbstractServiceTemplate<T, R> {

    /**
     * 是否请求成功
     */
    protected boolean success;

    /**
     * 入参
     */
    protected T param;

    /**
     * 返回数据
     */
    protected R data;

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

}
