package cn.luis.coca.boot.core.enums.code;

/**
 * 代码、描述枚举类接口
 *
 * @author luis
 * @since 1.0
 * 2022/10/6 21:55
 */
public interface CodeDescIEnum extends CodeIEnum {

    /**
     * 获取枚举描述
     *
     * @return desc
     */
    String getDesc();
}
