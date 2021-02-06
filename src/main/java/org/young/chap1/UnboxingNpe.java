package org.young.chap1;

/**
 * @author:ChuanShanJun
 * @date:2021/2/6
 * @description:
 */
public class UnboxingNpe {

    public static int add(int x, int y) {
        return x + y;
    }

    public static boolean compare(int x, int y) {
        return x >= y;
    }

    public static void main(String[] args) {
        // 1 变量赋值自动拆箱出现的空指针
        // javac UnboxingNpe.java
        // javap -c UnboxingNpe.class
//        Long count = null;
//        long count_ = count;

        // 2 方法传参时自动拆箱引发的空指针
//        Integer x = null;
//        Integer y = null;
//        System.out.println(add(x, y));

        // 3 用于大小比较的场景
        Integer left = 10;
        Integer right = null;
        System.out.println(compare(left, right));
    }
}
