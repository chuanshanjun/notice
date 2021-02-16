package org.young.chap3.clone_;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author:ChuanShanJun
 * @date:2021/2/16
 * @description:
 */
@Data
@AllArgsConstructor
public class Worker implements /* Cloneable*/ Serializable {

    private String name;
    private String age;
    private String gender;
    private EducationInfo educationInfo;

    public Worker(String name, String age, String gender, String school, String time) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.educationInfo = new EducationInfo(school, time);
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * <h2>深拷贝</h2>
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 1 第一种方式 缺点：需要自己new出来 相对于 native的 clone方法 更慢
//        return new Worker(name, age, gender, educationInfo.getSchool(), educationInfo.getTime());

        // 2 第二种方法 缺点：如果有多个引用嵌套的话，容易出现遗漏
//        Worker copyWorker = (Worker) super.clone();
//        EducationInfo copyEducationInfo = (EducationInfo) this.educationInfo.clone();
//        copyWorker.setEducationInfo(copyEducationInfo);
//        return copyWorker;

        // 3 第三种方法 使用序列化来实现-写在流中的是对象的深拷贝，原来的对象还存在于JVM中
        // 3.1 确保对象中所有类(包括其引用类型)都可以序列化
        // 3.2 创建输入输出流
        // 3.3 使用对象输入输出流
        // 3.4 将需要拷贝的对象传递给输出流
        // 3.5 从对象的输入流中读取新的对象并转换成你所需要的类
        Worker copyWorker = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            copyWorker = (Worker) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return copyWorker;
    }
}
