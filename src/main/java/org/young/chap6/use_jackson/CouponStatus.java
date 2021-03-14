package org.young.chap6.use_jackson;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author:ChuanShanJun
 * @date:2021/3/14
 * @description:
 */
@Getter
@AllArgsConstructor
public enum CouponStatus {

    USABLE("可用的", 1),
    USED("使用过的", 2),
    ;

    private String desc;
    private Integer code;
}
