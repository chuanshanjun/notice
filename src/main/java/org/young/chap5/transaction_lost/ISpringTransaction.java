package org.young.chap5.transaction_lost;

public interface ISpringTransaction {

    /** 主动捕获了异常，导致事务不能回滚 */
    void catchExceptionCanNotRollBack();

    /** 不是 unchecked 异常 不能回滚*/
    void notRuntimeExceptionCanNotRollBack() throws Exception;

    /** unchecked 异常 可以回滚 */
    void runtimeExceptionCanRollBack();

    /** 指定 rollbackFor 可以回滚 */
    void assignExceptionCanRollBack() throws Exception ;

    /** 同一个类中，一个不标注事务的方法，调用了标注事务的方可 不可以回滚 */
    void nonTransactionCanNotRollBack();
}
