package org.young.chap1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:ChuanShanJun
 * @date:2021/2/6
 * @description:
 */
public class BasicUsageNpe {

    public static boolean stringEquals(String x, String y) {
        return x.equals(y);
    }

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

    public static void main(String[] args) {
        // 1 字符串使用 equals 可能会报空指针错误
//        System.out.println(stringEquals("xyz", null));
//        System.out.println(stringEquals(null, "xyz"));

        // 2 对象数组new出来，但是元素没有初始化
//        User[] users = new User[10];
//        for (int i = 0; i < 10; i++) {
//            users[i] = new User();
//            users[i].name = "young" + 1;
//        }

        // 3 list对象 addAll 空指针
        List<User> list = new ArrayList<>();
        list.add(null);
        list.addAll(null);
    }
}
