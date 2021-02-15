package org.young.chap2.abstractClassAndInterface;

/**
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class Worker extends BaseWorker implements ProgramWork, IBaseWorking, IExtraWorking {
    @Override
    protected void clockIn() {

    }

    @Override
    protected void clockOut() {

    }

    @Override
    public void programing() {

    }

    @Override
    public void baseCoding() {

    }

    @Override
    public void baseTesting() {

    }

    @Override
    public void config() {
        System.out.println("Worker for Config");
    }

    @Override
    public void extraCoding() {

    }

    @Override
    public void extraTesting() {

    }
}
