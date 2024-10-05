package cn.luis.coca.boot.starter.data.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 删除标识
 */
@Getter
@AllArgsConstructor
public enum DeleteFlagEnum {

    NO(0), YES(1);

    /**
     * 删除标识在数据库中的数字
     */
    private final int number;
}