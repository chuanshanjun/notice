package org.young.chap5.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <h2>BeanFactoryPostProcessor经典用法，改变其他类的SCOPE</h2>
 * @author:ChuanShanJun
 * @date:2021/2/23
 * @description:
 */
@Slf4j
@Component
public class ThirdPartClassBeanFactoryPostProcess implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition thirdPartClass = beanFactory.getBeanDefinition("thirdPartClass");
        thirdPartClass.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
