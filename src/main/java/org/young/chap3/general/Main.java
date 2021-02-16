package org.young.chap3.general;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>理解范型</h1>
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main {

    /**
     * <h2>简单使用范型</h2>
     * 范型只是在编译时，通过编译器来限制类型
     * 在运行时对jvm来说是没有类型的
     */
    private static void easyUse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add("young");

        System.out.println(list1.getClass());
        System.out.println(list1.getClass() == list2.getClass());

        // 错误写法
//        if (list1 instanceof ArrayList<String>) {
//
//        }

        if (list1 instanceof ArrayList) {
            System.out.println("list1 instanceof ArrayList");
        }

        // ? 表示 不确定类型通配符
        if (list1 instanceof ArrayList<?>) {
            System.out.println("list1 instanceof ArrayList<?>");
        }

        // 在编译期List<String> 无法add String之外的类型
//        list1.add(10L);

        // 使用反射 在运行期 List<String> add String之外的类型
        list1.getClass().getMethod("add", Object.class).invoke(list1, 30L);

        for (Object o : list1) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        easyUse();
    }
}
