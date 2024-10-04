package cn.luis.coca.boot.core.enums.value;

/**
 * 只含value的枚举
 *
 * @author luis
 * @since 1.0
 * created 2022/2/28 9:43
 */
public interface ValueIEnum<V> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    V getValue();

}