package org.young.chap2.lombok_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    private String id;
    private String name;
}
