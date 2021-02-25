package org.young.chap5.transaction_lost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:ChuanShanJun
 * @date:2021/2/25
 * @description:
 */
@Slf4j
@Service
public class SpringTransactionImpl implements ISpringTransaction {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public void catchExceptionCanNotRollBack() {
        try {
            personDao.save(new Person("chuanshan"));
        } catch (Exception e) {
            log.info("catchExceptionCanNotRollBack");
            // 手动标记回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    @Transactional
    public void notRuntimeExceptionCanNotRollBack() throws Exception {
        try {
            personDao.save(new Person("chuanshan"));
        } catch (Exception e) {
            log.info("notRuntimeExceptionCanNotRollBack");
            throw new Exception("good");
        }
    }

    @Override
    @Transactional
    public void runtimeExceptionCanRollBack() {
        personDao.save(new Person("chuanshan"));
        throw new RuntimeException("good job");
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public void assignExceptionCanRollBack() throws CustomException {
        try {
            personDao.save(new Person("chuanshan"));
            throw new RuntimeException("balala");
        } catch (Exception e) {
            throw new CustomException("balalal");
        }
    }

    @Override
    public void nonTransactionCanNotRollBack() {
        anotherTransactionMethod();
    }

    @Transactional
    public void anotherTransactionMethod() {
        personDao.save(new Person("chuanshan"));
        throw new RuntimeException();
    }
}
