package org.young.chap5.multi_usable_bean;

import org.springframework.stereotype.Service;

/**
 * @author:ChuanShanJun
 * @date:2021/2/22
 * @description:
 */
@Service
public class MultiImplInterfaceImpl2 implements MultiImplInterface {
    @Override
    public void print() {
        System.out.println("MultiImplInterfaceImpl1");
    }
}
