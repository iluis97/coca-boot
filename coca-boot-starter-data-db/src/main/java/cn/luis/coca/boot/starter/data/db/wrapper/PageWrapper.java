package cn.luis.coca.boot.starter.data.db.wrapper;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 分页查询
 *
 * @param <T> extends {@link DbEntity}
 */
@Getter
@Setter
@ToString
public final class PageWrapper<T extends DbEntity> extends QueryWrapper {

    /**
     * 默认当前页码
     */
    public static final int DEFAULT_CURRENT = 1;

    /**
     * 默认每页显示条数
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * 默认每页最大显示条数
     */
    public static final int DEFAULT_MAX_PAGE = 100;

    /**
     * 查询条件
     */
    private T condition;

    /**
     * 当前页码，默认1
     */
    private int current = DEFAULT_CURRENT;

    /**
     * 每页显示条数，默认 10
     */
    private int size = DEFAULT_SIZE;

    /**
     * 总条数
     */
    private int total = 0;

    /**
     * 总页数
     */
    private int totalPage = 0;

    /**
     * 查询数据列表
     * <p>
     * tips: 没写只读List, 怕调用getRecords方法直接add
     * </p>
     */
    private List<T> records = new ArrayList<>();

    /**
     * jso反序列化使用
     */
    private PageWrapper() {

    }

    /**
     * 分页
     *
     * @param condition 查询条件
     */
    private PageWrapper(T condition) {
        this.condition = condition;
    }

    /**
     * 分页
     *
     * @param condition 查询条件
     * @param current   当前页码
     * @param size      每页显示条数
     */
    private PageWrapper(T condition, int current, int size) {
        this.condition = condition;
        this.current = current;
        // 保证最大每页显示条数不超限制
        checkSize(size);
        this.size = size;
    }

    /**
     * 生成PageCondition
     *
     * @param condition 查询条件
     * @param size      每页显示条数
     * @param <T>       <T extends DbEntity>
     * @return PageCondition
     */
    public static <T extends DbEntity> PageWrapper<T> firstPage(T condition, int size) {
        return new PageWrapper<>(condition, DEFAULT_CURRENT, size);
    }

    /**
     * 生成PageCondition
     *
     * @param condition 查询条件
     * @param size      每页显示条数
     * @param current   当前页码
     * @param <T>       <T extends DbEntity>
     * @return PageCondition
     */
    public static <T extends DbEntity> PageWrapper<T> of(T condition, int size, int current) {
        return new PageWrapper<>(condition, current, size);
    }

    /**
     * 生成PageCondition
     *
     * @param supplierCondition 查询条件
     * @param size              每页显示条数
     * @param current           当前页码
     * @param <T>               <T extends DbEntity>
     * @return PageCondition
     */
    public static <T extends DbEntity> PageWrapper<T> of(Supplier<T> supplierCondition, int size, int current) {
        return new PageWrapper<>(supplierCondition.get(), current, size);
    }

    /**
     * 生成PageCondition返回结果
     *
     * @param pageWrapper 查询条件
     * @param total       总条数
     * @param records     查询数据列表
     * @param <T>         <T extends DbEntity>
     * @return PageCondition
     */
    public static <T extends DbEntity> PageWrapper<T> result(PageWrapper<T> pageWrapper, long total, List<T> records) {
        int finalTotal = ((int) Math.min(total, Integer.MAX_VALUE));
        return result(pageWrapper, finalTotal, records);
    }

    /**
     * 生成PageCondition返回结果
     *
     * @param pageWrapper 查询条件
     * @param total       总条数
     * @param records     查询数据列表
     * @param <T>         <T extends DbEntity>
     * @return PageWrapper
     */
    public static <T extends DbEntity> PageWrapper<T> result(PageWrapper<T> pageWrapper, int total, List<T> records) {
        pageWrapper.setTotal(total);
        pageWrapper.setRecords(records);
        pageWrapper.setTotalPage(calculateTotalPage(total, pageWrapper.getSize()));
        return pageWrapper;
    }

    /**
     * 计算总页数
     *
     * @param total 总记录数
     * @param size  每页记录数
     * @return 总页数
     */
    public static int calculateTotalPage(int total, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        return (total + size - 1) / size;
    }

    /**
     * 保证不超限制
     *
     * @param number 数字
     */
    private static void checkSize(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Page size must be greater than 0.");
        }
        if (number > DEFAULT_MAX_PAGE) {
            throw new IllegalArgumentException("Page size must be less than INTEGER.MAX_VALUE.");
        }
    }

}
