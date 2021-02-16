package org.young.chap3.serialize_;

import java.io.*;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
public class Main {

    /**
     * <h1>序列化和反序列化people对象</h1>
     */
    private static void testSerializablePeople() throws IOException, ClassNotFoundException {
//        People people = new People(10L);
//
//        // 1 准备输出文件
//        File f = new File("/tmp/people_10.java_");
//        // 2 对象输出流
//        ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(f));
//        // 3 输出people对象
//        oos.writeObject(people);
//        // 关闭流
//        oos.close();
//
//        // 2 对象输入流
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
//        Object o = ois.readObject();
//        // 关闭流
//        ois.close();
//        System.out.println(o);
    }

    /**
     * <h2>子类实现序列化接口，父类没有实现序列化接口</h2>
     * 只要父类有无参的构造方法即可
     */
    private static void testSerializableWorker() throws Exception {
        Worker worker = new Worker(10L, "young", 20);

        File f = new File("/tmp/worker_10.java_");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(worker);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o);
    }

    /**
     * <h2>类中存在引用对象</h2>
     * 如果该对象需要序列化的话，其引用的对象也要实现序列化接口
     * @throws Exception
     */
    private static void testSerializableCombo() throws Exception {
        Worker worker = new Worker(10L, "young", 20);
        Combo combo = new Combo(10L, worker);

        File f = new File("/tmp/worker_10.java_");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(combo);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o);
    }

    /**
     * <h2>一个对象被序列化多次（之间有属性更新），会影像序列化嘛</h2>
     * java 序列化算法特性
     * 所有保存到磁盘的对象都有一个编码号
     * 当程序去序列化对象的时候会先检查该对象是否序列化过
     * 只有该对象从未被序列化后，该对象才会被序列化
     * 如果该对象已经被序列化，则会输出一个编码
     * 总结：不会重复序列化同一个对象，只会记录已经序列化对象的编码
     */
    private static void testManySerializable() throws Exception {
        Worker worker = new Worker(10L, "young", 20);

        File f = new File("/tmp/worker_10_c.java_");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(worker);
        oos.writeObject(worker);

        worker.setId(12L);
        worker.setAge(30);
        oos.writeObject(worker);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o1 = ois.readObject();
        Object o2 = ois.readObject();
        Object o3 = ois.readObject();
        ois.close();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
    }

    public static void main(String[] args) throws Exception {
//        testSerializablePeople();

//        testSerializableWorker();

//        testSerializableCombo();

        testManySerializable();
    }
}
