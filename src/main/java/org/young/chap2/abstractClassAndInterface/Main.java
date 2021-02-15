package org.young.chap2.abstractClassAndInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>Java8新增的静态方法和默认方法</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // 2 静态方法直接接口名.调用 类似于静态方法
        Integer min = list.stream().min(Comparator.comparing(value -> value)).get();
        Integer max = list.stream().max(Comparator.comparing(value -> value)).get();
        System.out.println(min);
        System.out.println(max);

        IBaseWorking.printTime();
        IExtraWorking.printTime();

        // 3 使用IBaseWorking的默认方法
        // 输出 IBaseWorking for Config
        Worker worker = new Worker();
        worker.config();

        // 4 worker实现的两个接口IBaseWorking和IExtraWorking都有默认方法config()
        // 则会出现多继承问题，此时只需worker实现自己的config方法即可避免该问题
        worker.config();
    }
}
