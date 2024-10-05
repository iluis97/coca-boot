package cn.luis.coca.boot.starter.data.db.entity;

import java.io.Serializable;

/**
 * 接口的继承 Serializable 并不意味着实现了这个接口的所有类自动成为 Serializable 的。
 * 这是因为接口的继承 Serializable 只是一个声明，它并不会影响实现类本身的序列化能力。
 * 实现类需要显式地实现 Serializable 接口才能进行序列化。
 * 当一个类实现了 Serializable 接口，它的所有子类也自然具备了序列化能力
 *
 * @see java.io.NotSerializableException
 * 标记db实体
 */
public interface DbEntity extends Serializable {
}
