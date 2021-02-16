package org.young.chap3.general;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>范型常见的问题</h1>
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class GeneralProblem {

    /**
     * <h2>范型是先检查再编译</h2>
     */
    public static void firstCheck() {
        List<String> list1 = new ArrayList<>();
        list1.add("haha");
//        list1.add(123L);
    }

    /**
     * <h2>范型不支持继承</h2>
     */
    public static void canNotExtend() {
        // 第一类错误
//        List<String> first = new ArrayList<Object>();
//
//        List<Object> list1 = new ArrayList<>();
//        list1.add(new Object());
//        // 此时从list2中获取的元素类型需是string,所以得Object转String,会产生转换异常
//        ArrayList<String> list2 = list1;

        // 第二类错误
//        List<Object> second = new ArrayList<String>();
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("wahha");
//        // 此时从list2中拿元素出来需要是Object，但我此时已经是String类型了 再向上转就自找没趣
//        List<Object> list2 = list1;
    }

    /**
     * <h2>范型类型变量不能是基本数据类型</h2>
     * 因为在运行时，类型已经擦出，此时存放的都是"Object"类型或者说是类类型
     */
    public static void baseTypeCanNotUseGenericity() {
//        List<int> list1 = new ArrayList<>();
    }

    /**
     * <h2>范型的类型参数，只能是类类型，不能是基本类型</h2>
     * 在java中 不定参数 ... 都认为是数组
     */
    private static <T> void doSomeThing(T... values) {
        for (T value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Integer[] ints1 = new Integer[]{1,2,3};
        // java会认为 只是一个数组类型，所以只 打印一个数组对象
        int[] ints2 = new int[]{1,2,3};

        doSomeThing(ints1);
        System.out.println("===>>>");
        doSomeThing(ints2);
    }
}
