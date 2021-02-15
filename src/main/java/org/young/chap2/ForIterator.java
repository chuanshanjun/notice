package org.young.chap2;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>for 循环</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class ForIterator {

    private static List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    private static List<Integer> r = Arrays.asList(1, 2, 3, 4, 5);

    private static void square(Integer x) {
        System.out.println(x * x);
    }

    public static void main(String[] args) {
        // 1 传统迭代
//        int[] xyz = new int[]{1,2,3,4,5,6};
//        for (int i = 0; i != xyz.length; i++) {
//            System.out.println(i);
//        }
//
//        // 2 使用迭代器
//        for (Iterator<Integer> iterator = l.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }

        // 3 在嵌套环境下容易出错-提前将外部嵌套的元素消耗完
//        for (Iterator<Integer> left = l.iterator(); left.hasNext(); ) {
//            for (Iterator<Integer> right = r.iterator(); right.hasNext(); ) {
//                System.out.println(left.next() * right.next());
//            }
//        }

        // 4 传统的正确嵌套循环 - 会存在多余的变量
//        for (Iterator<Integer> left = l.iterator(); left.hasNext(); ) {
//            Integer temp = left.next();
//            for (Iterator<Integer> right = r.iterator(); right.hasNext(); ) {
//                System.out.println(temp * right.next());
//            }
//        }

        // 5 for-each 优点：多余变量
//        for (Integer left : l) {
//            for (Integer right : r) {
//                System.out.println(left * right);
//            }
//        }

        // 6 iterable.forEach - 凡是实现iterable接口的都可以使用forEach方法
        l.forEach(x -> square(x));

        // 7 iterable.forEach 结合方法引用
        l.forEach(ForIterator::square);
    }
}
