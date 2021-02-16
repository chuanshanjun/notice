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
public class Combo implements Serializable {

    private long id;
    private Worker worker;

    public Combo(long id, Worker worker) {
        this.id = id;
        this.worker = worker;
    }
}
