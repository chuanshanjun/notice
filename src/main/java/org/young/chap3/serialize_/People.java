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
public abstract class People /* implements Serializable*/ {

    private long id;

    public People() {

    }

    public People(long id) {
        this.id = id;
    }
}
