package cn.luis.coca.boot.starter.data.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 基础审计DB实体Version
 */
@Getter
@Setter
public abstract class BaseAuditVersionEntity implements DbEntity {

    private static final long serialVersionUID = 222L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 乐观锁版本号
     */
    private Integer lockVersion;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

}
