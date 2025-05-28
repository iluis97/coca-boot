package cn.luis.coca.boot.core.enums.code;

/**
 * 代码、描述枚举类接口
 *
 * @author luis
 * @since 1.0
 * 2022/10/6 21:55
 */
public interface ResponseIEnum extends CodeDescIEnum {
    static ResponseIEnum ok() {
        return Response.ok;
    }

    static ResponseIEnum fail() {
        return Response.fail;
    }

    /**
     * 内部实现枚举，仅限内部使用，外部只能通过接口访问
     */
    enum Response implements ResponseIEnum {
        ok("200", "操作成功"),
        fail("5000", "系统执行出错");

        private final String code;
        private final String desc;

        Response(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }

}
