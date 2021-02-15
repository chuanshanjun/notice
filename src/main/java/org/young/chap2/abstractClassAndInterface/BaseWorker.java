package org.young.chap2.abstractClassAndInterface;

/**
 * <h1>每一个打工人的基本属性</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public abstract class BaseWorker {

    /** 起床时间 */
    protected int wakeUpTime = 8;

    /** 打卡时间 */
    protected abstract void clockIn();

    /** 下班时间 */
    protected abstract void clockOut();
}
