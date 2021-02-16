package org.young.chap3.reflect_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main {

    /**
     * <h2>当方法是基本类型时，反射获取method的参数也必须一致</h2>
     */
    private static void sameType() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Boss> clz = Boss.class;
        Method method = clz.getMethod("numeric", int.class);
        System.out.println(method.invoke(clz.newInstance(), 10));
    }

    /**
     * <h2>反射获取父类的method</h2>
     * getDeclaredMethod会失败
     * getMethod就直接可以
     */
    private static void superClassMethod() throws Exception {
//        Class<Boss> clz = Boss.class;
//        Method method = clz.getDeclaredMethod("worker", String.class);
////        Method method = clz.getMethod("worker", String.class);
//        System.out.println(method.invoke(clz.newInstance(), "wahahah"));
    }

    /**
     * <h2>通过递归的形式，查找父类的方法</h2>
     */
    private static Method getSuperMethod(Class<?> target, Class<?>[] args, String methodName) {
        Method method = null;
        try {
            method = target.getDeclaredMethod(methodName, args);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            System.out.println(target.getName() + "can not find method: " + methodName);
        }

        if (method == null && target != Object.class) {
            return getSuperMethod(target.getSuperclass(), args, methodName);
        }
        return method;
    }

    public static void main(String[] args) throws Exception {
//        sameType();
//        superClassMethod();
        getSuperMethod(Boss.class, new Class[]{String.class}, "worker");
    }
}
