package cn.luis.coca.boot.starter.data.db.wrapper;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;

import java.util.Optional;
import java.util.function.Function;

public abstract class QueryWrapper {

    /**
     * 构建查询条件
     */
    public static <T extends DbEntity, R> R buildQueryWrapper(T condition, Function<T, R> function) {
        return Optional.ofNullable(condition)
                .map(function)
                .orElse(null);
    }

    /**
     * 构建查询条件
     */
    public static <T extends DbEntity, R> Optional<R> buildQueryWrapperOptional(T condition, Function<T, R> function) {
        return Optional.ofNullable(condition)
                .map(function);
    }
}
