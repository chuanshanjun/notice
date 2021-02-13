package org.young.chap1;

import java.util.Optional;

/**
 * @author:ChuanShanJun
 * @date:2021/2/12
 * @description:
 */
public class OptionalUsage {

    public static class User {
        private String name;

        public String getName() {
            return name;
        }
    }

    private static void isUserEqualNull() {
        Optional<User> optional = Optional.empty();
        if (optional.isPresent()) {
            System.out.println("user is not null");
        } else {
            System.out.println("user is null");
        }
    }

    private static User anoymos() {
        return new User();
    }

    public static void main(String[] args) {
        // 没有意思的使用方法
        isUserEqualNull();

        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        // 存在即返回,空则提供默认值
        optionalUser.orElse(new User());
        // 存在即返回，空则由函数去产生
        optionalUser.orElseGet(() -> anoymos());
        // 存在即返回，否则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);

        // 存在则去做相应处理
        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        // map可以对Optional进行操作
        optionalUser.map(u -> u.getName()).orElse("anymos");
    }
}
