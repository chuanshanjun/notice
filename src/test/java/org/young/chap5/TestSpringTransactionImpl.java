package org.young.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.transaction_lost.ISpringTransaction;

/**
 * @author:ChuanShanJun
 * @date:2021/2/25
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringTransactionImpl {

    @Autowired
    private ISpringTransaction iSpringTransaction;

    @Test
    public void testTransaction() throws Exception {
//        iSpringTransaction.catchExceptionCanNotRollBack();

//        iSpringTransaction.notRuntimeExceptionCanNotRollBack();

//        iSpringTransaction.runtimeExceptionCanRollBack();

        iSpringTransaction.assignExceptionCanRollBack();

//        iSpringTransaction.nonTransactionCanNotRollBack();
    }
}
