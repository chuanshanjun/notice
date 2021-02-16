package org.young.chap2.function_lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1>Function and Lambda</h1>
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main {

    private static final Map<Long, Worker> id2WorkerMap = new HashMap<>();

    static {
        id2WorkerMap.put(1L, new Worker(1L, "young", 20));
    }

    public static void main(String[] args) {
        // 1 传统的写法-无参
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统使用匿名内部类");
            }
        }).start();

        // 2 使用Lambda写法
        new Thread(() -> System.out.println("lambda 写法")).start();

        List<String> list = Arrays.asList("x", "y", "z");

        // 3 传统写法-有参
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null)
                    return -1;
                if (s2 == null)
                    return 1;
                return s1.length() - s2.length();
            }
        });

        // 4 传统写法-无参
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null)
                return -1;
            if (s2 == null)
                return 1;
            return s1.length() - s2.length();
        });

        // 5 使用Lambda
        IFindWorker iFindWorker = id -> id2WorkerMap.get(id);
        System.out.println(iFindWorker.findWorker(1L));

        // 6 使用方法引用  这个方法正好满足这个lambda表达式
        IFindWorker iFindWorker1 = id2WorkerMap::get;
    }

    /**
     * <h2>要理解stream的中间操作和结束操作</h2>
     */
    public static void how2UseLambda() {
        List<String> names = Arrays.asList("young", "chuanshan");

        List<String> y = names.stream()
                .filter(x -> x.startsWith("y"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(y);
    }

    /**
     * <h2>Stream和lambda可能导致计算低效</h2>
     * 1 迭代次数多=函数调用多 每次函数调用都有中间结果产生，导致存储开销大
     */
    public static void badUseLambda() {
        List<String> names = Arrays.asList("young", "chuanshan", "yg");

        int y = names
                .stream()
                .filter(x -> x.startsWith("y"))
                .mapToInt(String::length)
                .max()
                .getAsInt();

        long maxLength = 0L;
        for (String name : names) {
            if (name.startsWith("y")) {
                long length = name.length();
                maxLength = Math.max(maxLength, length);
            }
        }
    }
}
