package org.young.chap5.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YoungServiceTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * <h2>bean名字是连续两个大写字母开头</h2>
     * 其名字是bean的完成名字
     * 默认beanName是首字母小写如， YoungService -> youngService
     * ex YOungService -> YOungService
     * 解决方案1 @Service("youngService") 在注解中声明
     * 结局方案2 通过class获取
     */
    @Test
    public void getBeanName() {
//        YOungService yOungService = (YOungService) applicationContext.getBean("yOungService");
        YoungService bean1 = (YoungService) applicationContext.getBean("youngService");
        bean1.print();

        YoungService bean2 = applicationContext.getBean(YoungService.class);
        bean2.print();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}