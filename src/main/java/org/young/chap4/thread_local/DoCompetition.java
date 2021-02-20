package org.young.chap4.thread_local;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class DoCompetition {

    public void code() {
        Competition.Material material = Competition.material.get();
        material.setCode(Thread.currentThread().getName());
        Competition.material.set(material);
    }

    public void config() {
        Competition.Material material = Competition.material.get();
        material.setConfig(Thread.currentThread().getName());
        Competition.material.set(material);
    }

    public void print() {
        System.out.printf("ThreadName %s, ThreadLocal HashCode %s, Instance HashCode %s name %s \n",
                Thread.currentThread().getName(),
                Competition.material.hashCode(),
                Competition.material.get().hashCode(),
                Competition.material.get().toString());
    }
}
