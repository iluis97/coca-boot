package cn.luis.coca.boot.core.dto.util;

import cn.luis.coca.boot.core.service.ServiceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceExecutorTest {


    @Test
    public void test() {
        HomeService homeService = new HomeService();
        ServiceResponse<Boolean> oneResp = homeService.isSafe(1);
        ServiceResponse<Boolean> twoResp = homeService.isSafe(4);

        Assertions.assertTrue(oneResp.getSuccess());
        Assertions.assertFalse(twoResp.getSuccess());
    }

}
