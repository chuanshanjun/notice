package org.young.chap2.abstractClassAndInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface IBaseWorking {

    void baseCoding();

    void baseTesting();

    /**
     * <h2>实现自定义的接口静态方法</h2>
     */
    static void printTime() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    /**
     * <h2>实现自定义的默认方法</h2>
     */
    default void config() {
        System.out.println("IBaseWorking for Config");
    }
}
