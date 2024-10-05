package cn.luis.coca.boot.starter.data.db.service;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * 数据查询接口, 只包含查询功能
 *
 * @param <T>
 * @param <ID>
 */
public interface DataService<T extends DbEntity, ID extends Serializable> extends DataQueryService<T, ID> {

    /**
     * 新增一条数据
     *
     * @param t 数据实体
     * @return 数据实体, 带id
     */
    Integer insert(T t);

    /**
     * 批量新增数据
     *
     * @param entities 数据实体集合
     * @return 数据实体集合, 带id
     */
    Integer insertInBatch(Collection<T> entities);

    /**
     * 根据id, 删除一条数据
     *
     * @param id 主键
     */
    Integer deleteById(ID id);

    /**
     * 根据id集合, 批量删除数据
     *
     * @param ids 主键集合
     */
    Integer deleteInBatch(Collection<ID> ids);

    /**
     * 根据数据实体, 按条件删除一条或多条数据
     *
     * @param entity 数据实体
     */
    Integer deleteByCondition(T entity);

    /**
     * 根据id, 更新一条数据
     *
     * @param id 主键
     */
    Integer updateById(ID id, T entity);

}
