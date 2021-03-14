package org.young.chap6;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap6.use_jackson.Coupon;
import org.young.chap6.use_jackson.CouponSerialize;

import java.text.SimpleDateFormat;

/**
 * @author:ChuanShanJun
 * @date:2021/3/14
 * @description:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestObjectMapper {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test1() throws Exception {
        // {"user":100,"assignTime":"10:13:51"}
        Coupon fake = Coupon.fake();
        fake.setTemplate(null);
        log.info("ObjectMapper Se Coupon: {}", objectMapper.writeValueAsString(fake));
    }

    @Test
    public void test2() throws Exception {
        Coupon fake = Coupon.fake();
        // 使用 @JsonSerialize(using = CouponSerialize.class) 注解
        log.info("ObjectMapper Se Coupon: {}", objectMapper.writeValueAsString(fake));
    }

    @Test
    public void test3() throws Exception {
        String jsonCoupon = "{\"id\":\"1\",\"userId\":\"100\",\"couponCode\":\"123456\"," +
                "\"assignTime\":\"00:48:35\"," +
                "\"status\":\"USABLE\"}";

        objectMapper.setDateFormat(new SimpleDateFormat("HH:mm:ss"));
        log.info("{}", objectMapper.readValue(jsonCoupon, Coupon.class));

        System.out.println(objectMapper.readValue(jsonCoupon, Coupon.class));
    }
}
