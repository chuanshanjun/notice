package org.young.chap3.string_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main {

    /**
     * <h2>使用字符串拼接,编译器会改成stringbuilder</h2>
     * javac Main.java
     * javap -l -c -p Main
     */
    private static void easyContact() {
        String username = "chuanshan";
        String age = "30";
        String job = "develop";

        String info = username + age + job;
        System.out.println(info);
    }

    /**
     * <h2>在for循环中使用拼接，每次都会新建StringBuilder</h2>
     */
    private static void implicitUseStringBuilder(String[] values) {
        String result = "";

        for (int i = 0; i < values.length; i++) {
            result += values[i];
        }

        System.out.println(result);
    }

    /**
     * <h2>优化使用stringbuilder后，则在for循环中只会append</h2>
     */
    private static void explicitUseStringBuilder(String[] values) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            result.append(values[i]);
        }

        System.out.println(result.toString());
    }
}
