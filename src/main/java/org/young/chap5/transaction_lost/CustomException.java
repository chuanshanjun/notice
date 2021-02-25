package org.young.chap5.transaction_lost;

/**
 * @author:ChuanShanJun
 * @date:2021/2/25
 * @description:
 */
public class CustomException extends Exception {
    public CustomException(String msg) {
        super(msg);
    }
}
