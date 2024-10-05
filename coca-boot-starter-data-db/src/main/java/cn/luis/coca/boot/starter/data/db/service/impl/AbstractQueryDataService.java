package cn.luis.coca.boot.starter.data.db.service.impl;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import cn.luis.coca.boot.starter.data.db.mapper.DataQueryMapper;
import cn.luis.coca.boot.starter.data.db.service.DataQueryService;
import cn.luis.coca.boot.starter.data.db.wrapper.PageWrapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractQueryDataService<T extends DbEntity, ID extends Serializable, Mapper extends DataQueryMapper<T, ID>> implements DataQueryService<T, ID> {

    private final Mapper mapper;

    protected AbstractQueryDataService(Mapper mapper) {
        this.mapper = mapper;
    }

    public DataQueryMapper<T, ID> getMapper() {
        return mapper;
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
