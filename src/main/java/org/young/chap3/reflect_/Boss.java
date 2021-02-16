package org.young.chap3.reflect_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Boss extends Worker {

    public String boss(String hello) {
        return Boss.class.getName() + ": " + hello;
    }

    public String numeric(int x) {
        return Boss.class.getName() + ": " + x;
    }
}
