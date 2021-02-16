package org.young.chap3.clone_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main implements Cloneable {

    /**
     * <h2>clone一定要实现cloneable接口</h2>
     */
    private static void canNotClone() throws CloneNotSupportedException {
        Main main = new Main();
        Object copy = main.clone();
    }

    /**
     * <h2>浅拷贝，修改引对对象则对原对象和拷贝对象都有影像</h2>
     * @throws CloneNotSupportedException
     */
    private static void copyTest() throws CloneNotSupportedException {
        Worker worker = new Worker("young","30", "male", new EducationInfo("CIT", "2000"));
        System.out.println("原对象" + worker.getEducationInfo().getSchool());
        Worker copyWorker = (Worker) worker.clone();
        System.out.println("copy对象" + copyWorker.getEducationInfo().getSchool());

        copyWorker.getEducationInfo().setSchool("god");
        System.out.println("原对象" + worker.getEducationInfo().getSchool());
        System.out.println("copy对象" + copyWorker.getEducationInfo().getSchool());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        canNotClone();
        copyTest();
    }
}
