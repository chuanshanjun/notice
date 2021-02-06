package org.young.chap1;

/**
 * @author:ChuanShanJun
 * @date:2021/2/6
 * @description:
 */
public class WhatIsNpe {

    public static class User {
        private String name;
        private User[] address;

        public void print() {
            System.out.println(this.name);
        }

        public String getName() {
            return null;
        }
    }

    public static class CutomException extends RuntimeException {

    }

    public static void main(String[] args) {
        // 1 调用了空对象的实例方法
//        User user = null;
//        user.print();

        // 2 访问了空对象的属性
//        User user = null;
//        System.out.println(user.name);

        // 3 当数组是空对象的时候取它的长度
//        User user = new User();
//        System.out.println(user.address.length);

        // 4 null 当作throw的值，扔出去
//        CutomException cutomException = null;
//        throw cutomException;

        // 5 方法的返回值是null，直接调用
//        User user = new User();
//        System.out.println(user.getName().contains("java"));
    }
}
