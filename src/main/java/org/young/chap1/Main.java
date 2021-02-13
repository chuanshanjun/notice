package org.young.chap1;

/**
 * <h1>演示try-with-resources</h1>
 * @author:ChuanShanJun
 * @date:2021/2/13
 * @description:
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 1 try 及 finally 中都有异常则finally中的异常会冲掉try中的异常
//        AutoClose autoClose = new AutoClose();
//        try {
//            autoClose.worker();
//        } finally {
//            autoClose.close();
//        }

        // 2 使用try with resource则不会被冲掉
        try (AutoClose autoClose = new AutoClose()) {
            autoClose.worker();
        }
    }
}
