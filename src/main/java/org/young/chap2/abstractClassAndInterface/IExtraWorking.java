package org.young.chap2.abstractClassAndInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface IExtraWorking {

    void extraCoding();

    void extraTesting();

    /**
     * <h2>实现自定义的默认方法</h2>
     */
    default void config() {
        System.out.println("IExtraWorking for Config");
    }

    /**
     * <h2>实现自定义的接口静态方法</h2>
     */
    static void printTime() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
