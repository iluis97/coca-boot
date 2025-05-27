package cn.luis.coca.boot.core.dto.util;

import cn.luis.coca.boot.core.service.AbstractServiceTemplate;
import cn.luis.coca.boot.core.service.ServiceExecutor;
import cn.luis.coca.boot.core.service.ServiceResponse;

public class HomeService {


    public ServiceResponse<Boolean> isSafe(int doorNumber) {
        return ServiceExecutor.execute(new AbstractServiceTemplate<>() {
            @Override
            public void doCheck() {
                if (doorNumber > 3) {
                    throw new RuntimeException("整这些门干啥");
                }
            }

            @Override
            public void doExecute() {
                this.markSuccess(Boolean.TRUE);
            }
        });
    }

}
