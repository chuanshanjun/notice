package org.young.chap3.serialize_;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
@Getter
@Setter
@ToString
public class Worker extends People implements Serializable {

    private String name;
    private Integer age;

    public Worker(long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
