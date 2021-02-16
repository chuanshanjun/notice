package org.young.chap3.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>使用原始类型的坑</h1>
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class GeneralType {

    /**
     * <h2>原始类型</h2>
     */
    private static void originType() {
        // 1 List后面无指定类型的就是原始类型
        List list = new ArrayList();

        list.add(19);
        list.add("name");
        list.add("username chuanshan");

        // 2 使用原始类型会导致一些运行时异常
//        list.stream().forEach( o -> {
//            if (((String) o).equals("name")) {
//                System.out.println(list.indexOf(o));
//            }
//        });

        // 3 解决以下问题
//        list.stream().forEach(o -> {
//            if (o instanceof String && ((String) o).equals("name")) {
//                System.out.println(list.indexOf(o));
//            }
//        });
    }

    /**
     * <h2>优化原始类型</h2>
     * 1 标明存储的类型
     */
    private static void optimizeUse() {
        List<Object> list = new ArrayList<>();
        list.add(19);
        list.add("young");
        list.add("chuanshan");
    }

    /**
     * <h2>优化原始类型</h2>
     * 2 指明存储的具体类型
     */
    private static void optimizeUse2() {
        User user = new User(19, "chuanshan", "chuanshanjun");
        List<User> list = new ArrayList<>();
        list.add(user);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class User {
        private Integer id;
        private String name;
        private String username;
    }

    public static void main(String[] args) {
        originType();
    }
}
