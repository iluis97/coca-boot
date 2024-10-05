package cn.luis.coca.boot.starter.data.db.service;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import cn.luis.coca.boot.starter.data.db.wrapper.PageWrapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 数据查询接口, 只包含查询功能
 *
 * @param <T>
 * @param <ID>
 */
public interface DataQueryService<T extends DbEntity, ID extends Serializable> {

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 数据实体
     */
    T queryById(ID id);

    /**
     * 根据id查询, 返回Optional[不支持序列化&反序列化]
     *
     * @param id 主键
     * @return 数据实体
     */
    Optional<T> findById(ID id);

    /**
     * 根据id集合查询, 返回数据实体集合
     *
     * @param ids 主键集合
     * @return 数据实体
     */
    List<T> queryByIds(Collection<ID> ids);

    /**
     * 根据数据实体条件查询, 返回数据实体集合
     *
     * @param entity 主键集合
     * @return 数据实体
     */
    List<T> queryByCondition(T entity);

    /**
     * 按条件分页查询
     *
     * @param pageWrapper 分页条件
     * @return 查询结果
     */
    PageWrapper<T> queryByPage(PageWrapper<T> pageWrapper);

}
