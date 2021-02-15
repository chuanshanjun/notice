package org.young.chap2;

import java.util.*;

/**
 * <h1>equalsAndHashCode</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class EqualsAndCompare {

    public static void main(String[] args) {
        // 1 使用默认的equals方法
        User user1 = new User("young", 20);
        User user2 = new User("young", 21);

        // 2 默认的equals方法是看两个引用是否指向同一个内存地址
//        System.out.println(user1.equals(user2));

        // 3 重写equals方法-set和map还认为是两个不一样的对象，因为它们先使用hashCode方法来判断是否是一个对象，再用equals方法
//        Set<User> set1 = new HashSet<>();
//        set1.add(user1);
//        set1.add(user2);
//
//        Map<User, String> map = new HashMap<>();
//        map.put(user1, "user1");
//        map.put(user2, "user2");
//
//        System.out.println(set1.size());
//        System.out.println(map.size());

        // 4 重写hashCode方法，将两个对象认为是一个对象
//        Set<User> set1 = new HashSet<>();
//        set1.add(user1);
//        set1.add(user2);
//
//        Map<User, String> map = new HashMap<>();
//        map.put(user1, "user1");
//        map.put(user2, "user2");
//
//        System.out.println(set1.size());
//        System.out.println(map.size());

        // 5 索引 ArrayList.indexOf方法使用equals Collections.binarySearch使用compareTo方法
        // compareTo 与 equals 的实现过程需要同步
        User user = new User("young", 21);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        int index1 = list.indexOf(user);
        int index2 = Collections.binarySearch(list, user);
        System.out.println(index1);
        System.out.println(index2);
    }

    private static class User implements Comparable<User> {
        private String name;
        private Integer old;

        @Override
        public boolean equals(Object o) {
            if (o instanceof User) {
                User user = (User) o;
                return this.name.equals(user.name) && this.old.equals(user.old);
            }

            return false;
        }

        @Override
        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31;
            return result;
        }

        public User(String name, Integer old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOld() {
            return old;
        }

        public void setOld(Integer old) {
            this.old = old;
        }

        @Override
        public int compareTo(User user) {
            return (this.old - user.old) + this.name.compareTo(user.name);
        }
    }
}
