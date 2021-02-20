package org.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.young.chap5.application_context.ApplicationContextStore;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        // 1 第一种方法
//        SpringApplication springApplication = new SpringApplication(App.class);
        // 在启动的时候新增一个ApplicationContextInitializer
        // 容器创建完成后会回调initialize()
//        springApplication.addInitializers(new UseInitializer());
//        springApplication.run(args);

        // 2 第三种方式是使用SpringBoot应用程序返回
//        ApplicationContextStore.setApplicationContext(SpringApplication.run(App.class, args));
    }
}

