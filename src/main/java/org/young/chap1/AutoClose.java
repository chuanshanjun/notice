package org.young.chap1;

/**
 * @author:ChuanShanJun
 * @date:2021/2/13
 * @description:
 */
public class AutoClose implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println(">>> close");
        throw new RuntimeException("Exception in close()");
    }

    public void worker() throws MyException {
        System.out.println(">>> worker");
        throw new MyException("Exception in worker");
    }
}
