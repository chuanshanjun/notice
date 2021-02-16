package org.young.chap3.clone_;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
@Data
@AllArgsConstructor
public class EducationInfo implements /* Cloneable*/ Serializable {
    private String school;
    private String time;

    /**
     * <h2>Object.clone() 是 native 方法 速度较快，且是浅拷贝</h2>
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
