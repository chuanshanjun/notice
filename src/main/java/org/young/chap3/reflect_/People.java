package org.young.chap3.reflect_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class People {

    public String people(String hello) {
        return People.class.getName() + ": " + hello;
//        return this.getClass().getName() + ": " + hello;
    }

    public static void main(String[] args) {
        People p = new People();
        System.out.println(p.people("hello"));
    }
}
