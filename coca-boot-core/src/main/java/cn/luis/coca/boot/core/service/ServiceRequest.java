package cn.luis.coca.boot.core.service;

import lombok.Getter;

import java.io.Serializable;

/**
 * 服务间调用通用入参
 *
 * @author Luis
 * @since 2025/05/27 9:29
 */
@Getter
public class ServiceRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Condition condition;

    public ServiceRequest() {
        this.condition = null;

    }

    public ServiceRequest(Condition condition) {
        this.condition = condition;
    }
}
