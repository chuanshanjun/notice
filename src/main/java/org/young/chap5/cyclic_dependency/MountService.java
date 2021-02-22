package org.young.chap5.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:ChuanShanJun
 * @date:2021/2/22
 * @description:
 */
@Service
public class MountService {

//    private LakeService lakeService;

//    @Autowired
//    public MountService(LakeService lakeService) {
//        this.lakeService = lakeService;
//    }

    @Autowired
    private LakeService lakeService;

    public void print() {
        System.out.println("this is lake service");
    }
}
