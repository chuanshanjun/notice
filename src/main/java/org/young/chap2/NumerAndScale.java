package org.young.chap2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h1>BigDecimal</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class NumerAndScale {

    /**
     * <h2>scale 需要与小数位精确</h2>
     */
    private static void scaleProblem() {
        // 1 设置精度时需要>=小数位
//        BigDecimal bd1 = new BigDecimal("12.222");
//        BigDecimal result = bd1.setScale(2);

//        BigDecimal bd1 = new BigDecimal("12.222");
//        BigDecimal result = bd1.setScale(3);

        BigDecimal bd1 = new BigDecimal("12.222");
        BigDecimal result = bd1.setScale(3);
        System.out.println(result);
    }

    /**
     * <h2>除法结果需要精确</h2>
     */
    private static void bigDecimalDivide() {
        // 1 30/7是除不尽的
//        BigDecimal bd1 = new BigDecimal(30);
//        BigDecimal bd2 = new BigDecimal(7);
//        System.out.println(bd1.divide(bd2));

        // 2 使用四舍五入
        BigDecimal bd1 = new BigDecimal(30);
        BigDecimal bd2 = new BigDecimal(7);
        System.out.println(bd1.divide(bd2, RoundingMode.HALF_UP));

    }

    /**
     * <h2>数值比较 需确定精度</h2>
     */
    private static void bigDecimalCompare() {
        BigDecimal bd1 = new BigDecimal("12.22");
        BigDecimal bd2 = new BigDecimal("12.220");
        System.out.println(bd1.equals(bd2));
        System.out.println(bd1.compareTo(bd2) == 0);
    }

    public static void main(String[] args) {
//        scaleProblem();

//        bigDecimalDivide();

        bigDecimalCompare();
    }
}
