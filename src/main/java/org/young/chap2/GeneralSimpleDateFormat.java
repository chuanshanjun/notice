package org.young.chap2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <h1>SimpleDateFormat常见的问题</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class GeneralSimpleDateFormat {

    /**
     * <h2>只能转换精度高的，转换不了精度低的</h2>
     */
    private static void parseDate() throws ParseException {
        // yyy-MM-dd HH:mm:ss 注 月-M大写 小时H大写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2021-02-14 10:00:00");
        System.out.println(d1);
        Date d2 = sdf.parse("2021-02");
        System.out.println(d2);
    }

    public static void main(String[] args) throws ParseException {
//        parseDate();
        safeParse();
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * <h2>多线程下不安全，解决方案-1 局部变量 2 threadLocal 3 snchronized</h2>
     */
    private static void safeParse() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 100, 10, TimeUnit.MINUTES, new LinkedBlockingDeque<>(1000));
        
        while (true) {
            executor.execute(() -> {
                String dateString = "2021-02-14 10:00:00";
                try {
                    Date d1 = sdf.parse("2021-02-14 10:00:00");
                    String format = sdf.format(d1);
                    System.out.println(format.equals(dateString));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
