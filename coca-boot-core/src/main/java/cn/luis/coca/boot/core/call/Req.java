package cn.luis.coca.boot.core.call;

import lombok.Getter;

import java.io.Serializable;

/**
 * 服务间调用通用入参
 *
 * @author Luis
 * @since 2025/05/27 9:29
 */
@Getter
public class Req implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Condition condition;

    public Req() {
        this.condition = null;

    }

    public Req(Condition condition) {
        this.condition = condition;
    }
}
