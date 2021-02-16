package org.young.chap2.function_lambda;

/**
 * <h1>函数式接口 有且仅有一个抽象接口</h1>
 */
@FunctionalInterface
public interface IFindWorker {

    Worker findWorker(Long id);
}
