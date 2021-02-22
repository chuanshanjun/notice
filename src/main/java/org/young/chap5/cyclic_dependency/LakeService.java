package org.young.chap5.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:ChuanShanJun
 * @date:2021/2/22
 * @description:
 */
@Service
public class LakeService {

    private MountService mountService;

    /**
     * <h2>使用构造注入的时候spring无法为你解决循环依赖</h2>
     * @param mountService
     */
//    @Autowired
//    public LakeService(MountService mountService) {
//        this.mountService = mountService;
//    }

    /**
     * <h2>使用field注入，可以避免循环依赖</h2>
     */
//    @Autowired
//    private MountService mountService;

    /**
     * <h2>使用set注入可以避免循环依赖</h2>
     * @param mountService
     */
    @Autowired
    private void setMountService(MountService mountService) {
        this.mountService = mountService;
    }

    public void print() {
        System.out.println("this is mountService");
    }
}
