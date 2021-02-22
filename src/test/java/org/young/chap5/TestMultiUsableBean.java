package org.young.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.multi_usable_bean.MultiImplInterface;
import org.young.chap5.multi_usable_bean.NullImpInterface;

import javax.annotation.Resource;

/**
 * @author:ChuanShanJun
 * @date:2021/2/21
 * @description:
 */
@SuppressWarnings("all")
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMultiUsableBean {

    /**
     * <h2>@Autowired默认使用类型进行注入</h2>
     * 当前注入的redis是springboot-start
     * * @Qualifier结合@Autowored一起使用自动注入策略从byType变成byName
     */
//    @Autowired
//    @Qualifier("youngRedisTemplate")
//    private RedisTemplate redisTemplate;

//    /**
//     * <h2>@Resource按照名称注入</h2>
//     */
//    @Resource
//    private RedisTemplate youngRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * <h2>定义了接口，却没有实现</h2>
     * 会抛出NoSuchBeanDefinitionException
     * SprignBean容器启动的前提就是，它管理的bean都是正确的
     * required表示不需要spring注入，则当无此bean的时候，容器也可以成功
     * 启动
     */
    @Autowired(required = false)
    private NullImpInterface nullImpInterface;

    /**
     * <h2>一个接口有多实现</h2>
     * 但注入的时候使用@Autowired，则报NoUniqueBeanDefinitionException
     * 此时通过@Qualifier("multiImplInterfaceImpl1") 通过名字来实现注入
     */
    @Autowired
    @Qualifier("multiImplInterfaceImpl1")
    private MultiImplInterface multiImplInterface1;

    @Autowired
    @Qualifier("multiImplInterfaceImpl2")
    private MultiImplInterface multiImplInterface2;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("name", "young");
//        youngRedisTemplate.opsForValue().set("name", "young");

        multiImplInterface1.print();
        multiImplInterface2.print();
    }
}
