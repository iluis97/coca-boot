package cn.luis.coca.boot.core.util;

import cn.luis.coca.boot.core.dto.response.ServiceResponse;

public class ServiceExecutor {

    public static <T> ServiceResponse<T> execute(AbstractServiceTemplate<T> serviceTemplate) {
        ServiceResponse<T> serviceResponse = executeFull(serviceTemplate);
        // 不透出具体异常
        serviceTemplate.setException(null);
        return serviceResponse;
    }


    public static <T> ServiceResponse<T> executeFull(AbstractServiceTemplate<T> serviceTemplate) {
        try {
            serviceTemplate.doCheck();
            serviceTemplate.doBefore();
            serviceTemplate.doExecute();
            serviceTemplate.doAfter();
        } catch (Exception e) {
            serviceTemplate.markFail(e);
            serviceTemplate.doWhenException();
        } finally {
            try {
                serviceTemplate.doFinally();
            } catch (Exception ex) {
                serviceTemplate.markFail(ex);
                serviceTemplate.doWhenFinallyException();
            }
        }
        if (serviceTemplate.getSuccess() == null) {
            return ServiceResponse.fail("预期之外的异常");
        }
        if (serviceTemplate.getSuccess() == Boolean.FALSE || serviceTemplate.getException() != null) {
            return ServiceResponse.failException(serviceTemplate.getException());
        }
        return ServiceResponse.success(serviceTemplate.getData());
    }


}