package cn.luis.coca.boot.starter.data.db.wrapper;

import cn.luis.coca.boot.starter.data.db.entity.DbEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Supplier;

public class PageWrapperTest {

    private static final TestDbEntity testDbEntity = new TestDbEntity();

    @Test
    public void testFirstPage() {
        Assertions.assertNotNull(PageWrapper.firstPage(testDbEntity, PageWrapper.DEFAULT_SIZE));
    }

    @Test
    public void testOf() {

        Assertions.assertNotNull(PageWrapper.of(testDbEntity, PageWrapper.DEFAULT_SIZE, PageWrapper.DEFAULT_CURRENT));

        Supplier<DbEntity> supplier = () -> testDbEntity;
        Assertions.assertNotNull(PageWrapper.of(supplier, PageWrapper.DEFAULT_SIZE, PageWrapper.DEFAULT_CURRENT));

    }

    @Test
    public void testResult() {
        PageWrapper<TestDbEntity> pageWrapper = PageWrapper.firstPage(testDbEntity, PageWrapper.DEFAULT_SIZE);

        PageWrapper<TestDbEntity> pw = PageWrapper.result(pageWrapper, 1, Collections.singletonList(testDbEntity));
        Assertions.assertNotNull(pw);
    }

}
