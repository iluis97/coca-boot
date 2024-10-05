package cn.luis.coca.boot.starter.data.db.service.impl;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import cn.luis.coca.boot.starter.data.db.mapper.DataMapper;
import cn.luis.coca.boot.starter.data.db.service.DataService;
import cn.luis.coca.boot.starter.data.db.wrapper.PageWrapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDataService<T extends DbEntity, ID extends Serializable, Mapper extends DataMapper<T, ID>> implements DataService<T, ID> {

    private final Mapper mapper;

    protected AbstractDataService(Mapper mapper) {
        this.mapper = mapper;
    }

    public DataMapper<T, ID> getMapper() {
        return mapper;
    }

    @Override
    public Integer insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public Integer insertInBatch(Collection<T> entities) {
        return mapper.insertInBatch(entities);
    }

    @Override
    public Integer deleteById(ID id) {
        return mapper.deleteById(id);
    }

    @Override
    public Integer deleteInBatch(Collection<ID> ids) {
        return mapper.deleteInBatch(ids);
    }

    @Override
    public Integer deleteByCondition(T entity) {
        return mapper.deleteByCondition(entity);
    }

    @Override
    public Integer updateById(ID id, T entity) {
        return mapper.updateById(id, entity);
    }

    @Override
    public T queryById(ID id) {
        return mapper.queryById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(mapper.queryById(id));
    }

    @Override
    public List<T> queryByIds(Collection<ID> ids) {
        return mapper.queryByIds(ids);
    }

    @Override
    public List<T> queryByCondition(T entity) {
        return mapper.queryByCondition(entity);
    }

    @Override
    public PageWrapper<T> queryByPage(PageWrapper<T> pageWrapper) {
        return mapper.queryByPage(pageWrapper);
    }
}
