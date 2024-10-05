package cn.luis.coca.boot.starter.data.db.wrapper;

import cn.luis.coca.boot.starter.data.db.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TestDbEntity extends BaseEntity {

    private String name;
    private int age;

}
