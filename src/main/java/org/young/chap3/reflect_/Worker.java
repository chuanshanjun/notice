package org.young.chap3.reflect_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Worker extends People {

    public String worker(String hello) {
        return Worker.class.getName() + ": " + hello;
    }
}
