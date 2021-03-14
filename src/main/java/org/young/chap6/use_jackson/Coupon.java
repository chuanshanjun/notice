package org.young.chap6.use_jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author:ChuanShanJun
 * @date:2021/3/14
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 1 使用注解达到，序列化时你需要的效果 2 使用自定义的序列化类
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"couponCode", "status"})
@JsonSerialize(using = CouponSerialize.class)
public class Coupon {

//    @JsonIgnore
    private int id;

//    @JsonProperty("user")
    private Long userId;

    private String couponCode;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private Date assignTime;

    private CouponStatus status;

    private CouponTemplate template;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CouponTemplate {
        private String name;
        private String logo;
    }

    public static Coupon fake() {
        return new Coupon(1, 100L, "123456", new Date(),
                CouponStatus.USABLE, new CouponTemplate("couponTemplate", "young"));
    }
}
