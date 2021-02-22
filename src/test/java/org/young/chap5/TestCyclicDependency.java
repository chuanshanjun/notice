package org.young.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.cyclic_dependency.LakeService;
import org.young.chap5.cyclic_dependency.MountService;

/**
 * @author:ChuanShanJun
 * @date:2021/2/22
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCyclicDependency {

    @Autowired
    private LakeService lakeService;

    @Autowired
    private MountService mountService;

    @Test
    public void test1() {
        lakeService.print();
        mountService.print();
    }
}
