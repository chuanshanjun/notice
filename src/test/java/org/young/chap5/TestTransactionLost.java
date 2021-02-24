package org.young.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.transaction_lost.Person;
import org.young.chap5.transaction_lost.PersonDao;

/**
 * @author:ChuanShanJun
 * @date:2021/2/24
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionLost {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testAdd() {
        Person p = new Person();
        p.setByte((byte)0x1);
        p.setName("young");
        personDao.save(p);
    }
}
