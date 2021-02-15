package org.young.chap2.lombok_;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>Lombok坑</h1>
 * @author:ChuanShanJun
 * @date:2021/2/15
 * @description:
 */
public class Main {

    /**
     * Lombok第一个坑,第一个首字母小写
     * @throws Exception
     */
    private static void singleAplphabetHump() throws Exception {
        Person person = new Person();
        person.setName("young");
        person.setIPhone("xxx");
        person.setUserName("young-imooc");

        ObjectMapper ob = new ObjectMapper();
        String s = ob.writeValueAsString(person);
        // {"name":"young","userName":"young-imooc","iphone":"xxx"}
        // 原先属性是iPhone -> iphone 按照Java规范驼峰命名时 因避免单个首字母小写
        // 不然会造成json反序列化异常
        System.out.println(s);

        String json = "{\"name\":\"young\",\"userName\":\"young-imooc\",\"iPhone\":\"xxx\"}";
        Person person1 = ob.readValue(json, Person.class);
        System.out.println(person1);
    }

    /**
     * <h2>equalsAndHasCode坑</h2>
     * 子类不增加@EqualsAndHashCode(callSuper = true) 会导致equals的时候只比较父类的属性
     * @Data 中带的@EqualsAndHashCode的callSuper默认False
     */
    private static void equalsAndHashCodeBug() {
        AppleComput a1 = new AppleComput("1", "mac pro", 400L, "white");
        AppleComput a2 = new AppleComput("2", "mac air", 400L, "white");
        System.out.println(a1.equals(a2));
    }

    public static void main(String[] args) throws JsonProcessingException {
        equalsAndHashCodeBug();
    }
}
