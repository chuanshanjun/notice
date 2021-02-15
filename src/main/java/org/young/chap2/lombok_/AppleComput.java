package org.young.chap2.lombok_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AppleComput extends Computer {

    private long price;
    private String color;

    public AppleComput(String id, String name, long price, String color) {
        super(id, name);
        this.price = price;
        this.color = color;
    }
}
