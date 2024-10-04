package cn.luis.coca.boot.util;

import org.slf4j.helpers.MessageFormatter;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 调用熔断器
 *
 * @param <T> 返回的数据
 * @author luis
 */
public class InvokeFuse<T> implements Supplier<T> {

    /**
     * 实际调用
     */
    private final Callable<T> callable;

    /**
     * 容错处理
     */
    private final Function<Throwable, T> fuseHandler;

    /**
     * 构造函数
     *
     * @param callable    实际调用
     * @param fuseHandler 容错处理
     */
    private InvokeFuse(Callable<T> callable, Function<Throwable, T> fuseHandler) {
        this.callable = callable;
        this.fuseHandler = fuseHandler;
    }

    /**
     * of
     *
     * @param callable    实际调用
     * @param fuseHandler 容错处理
     */
    public static <T> InvokeFuse<T> of(Callable<T> callable, Function<Throwable, T> fuseHandler) {
        return new InvokeFuse<T>(callable, fuseHandler);
    }

    /**
     * ofValue
     *
     * @param callable     实际调用
     * @param defaultValue 默认值
     */
    public static <T> InvokeFuse<T> ofValue(Callable<T> callable, T defaultValue) {
        return new InvokeFuse<T>(callable, e -> defaultValue);
    }

    /**
     * 日志不带错误信息
     *
     * @param log            日志
     * @param messagePattern 日志信息模板
     * @param argArray       日志数据
     * @return 调用熔断器
     */
    public InvokeFuse<T> log(Log log, String messagePattern, Object... argArray) {
        return new InvokeFuse<T>(callable, e -> {
            log.log(MessageFormatter.arrayFormat(messagePattern, argArray).getMessage());
            return fuseHandler.apply(e);
        });
    }

    /**
     * 日志带错误信息
     *
     * @param logEx          日志
     * @param messagePattern 日志信息模板
     * @param argArray       日志数据
     * @return 调用熔断器
     */
    public InvokeFuse<T> logEx(LogEx logEx, String messagePattern, Object... argArray) {
        return new InvokeFuse<T>(callable, e -> {
            logEx.log(MessageFormatter.arrayFormat(messagePattern, argArray).getMessage(), e);
            return fuseHandler.apply(e);
        });
    }

    /**
     * 获取实际值
     *
     * @return 实际值
     */
    @Override
    public T get() {
        try {
            return callable.call();
        } catch (Exception e) {
            return fuseHandler.apply(e);
        }
    }

    /**
     * log interface
     */
    @FunctionalInterface
    public interface Log {
        /**
         * @param errorMessage 异常信息
         * @see org.slf4j.Logger#info
         * @see org.slf4j.Logger#warn
         */
        void log(String errorMessage);
    }

    /**
     * LogEx interface
     */
    @FunctionalInterface
    public interface LogEx {
        /**
         * @param errorMessage 异常信息
         * @param throwable    异常
         * @see org.slf4j.Logger#warn
         * @see org.slf4j.Logger#error
         */
        void log(String errorMessage, Throwable throwable);
    }

}
