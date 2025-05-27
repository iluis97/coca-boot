package cn.luis.coca.boot.starter.data.db.entity;

import java.io.Serializable;

/**
 * 当一个类实现了 Serializable 接口，它的所有子类也自然具备了序列化能力
 *
 * @see java.io.NotSerializableException
 * 标记db实体
 */
public interface DbEntity extends Serializable {
}
