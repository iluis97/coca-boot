package cn.luis.coca.boot.starter.data.db.mapper;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import cn.luis.coca.boot.starter.data.db.service.DataQueryService;

import java.io.Serializable;

public interface DataQueryMapper<T extends DbEntity, ID extends Serializable> extends DataQueryService<T, ID> {
}
