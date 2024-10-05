package cn.luis.coca.boot.starter.data.db.mapper;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import cn.luis.coca.boot.starter.data.db.service.DataService;

import java.io.Serializable;

public interface DataMapper<T extends DbEntity, ID extends Serializable> extends DataService<T, ID> {
}
