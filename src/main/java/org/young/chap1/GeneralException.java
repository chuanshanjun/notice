package org.young.chap1;

import com.google.common.base.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:ChuanShanJun
 * @date:2021/2/12
 * @description:
 */
public class GeneralException {

    private static class User {
        private String name;

        private String getName() {
            return name;
        }
    }

    private static class Manager extends User {

    }

    private static class Worker extends User {

    }

    private static Map<String, StaffTypeEnum> typeIndex = new HashMap<>(StaffTypeEnum.values().length);

    static {
        for (StaffTypeEnum value : StaffTypeEnum.values()) {
            typeIndex.put(value.name(), value);
        }
    }

    private static StaffTypeEnum enumFind(String type) {
        // 1 最普通 最简单的实现
//        try {
//            return StaffTypeEnum.valueOf(type);
//        } catch (IllegalArgumentException e) {
//            return null;
//        }

        // 2 改进的实现，但效率不高
//        for (StaffTypeEnum value : StaffTypeEnum.values()) {
//            if (value.name().equals(type)) {
//                return value;
//            }
//        }
//        return null;

        // 3 静态map索引，只有一次循环枚举的过程
//        return typeIndex.get(type);

        // 4 使用google guava enums
        return Enums.getIfPresent(StaffTypeEnum.class, type).orNull();
    }

    public static void main(String[] args) {
//        User user1 = new Manager();
//        User user2 = new Worker();
//
//        Manager m1 = (Manager) user1;
////        Manager m2 = (Manager) user2;
//        // 1 输出判断
//        System.out.println(user2.getClass().getName());
//        // 2 instanceOf 关键字
//        System.out.println(user2 instanceof Worker);

        // 3 枚举查找异常
        System.out.println(enumFind("XX"));

    }
}
