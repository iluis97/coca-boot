package cn.luis.coca.boot.core.dto;

import cn.luis.coca.boot.core.dto.AbstractServiceTemplate;

public class ServiceExecutor {

    public <T, R> R execute(AbstractServiceTemplate<T, R> serviceTemplate) {
        serviceTemplate.doCheck();
        serviceTemplate.doBefore();
        serviceTemplate.doExecute();
        serviceTemplate.doAfter();
        return serviceTemplate.getData();
    }

    public <T, R> R executeWithTransaction(AbstractServiceTemplate<T, R> serviceTemplate) {
        serviceTemplate.doCheck();
        serviceTemplate.doBefore();
        serviceTemplate.doExecute();
        serviceTemplate.doAfter();
        return serviceTemplate.getData();
    }


}