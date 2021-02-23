package org.young.chap5.bean_post_processor;

import org.springframework.stereotype.Service;

/**
 * @author:ChuanShanJun
 * @date:2021/2/23
 * @description:
 */
@Service
public class WMVDecoder implements IDecoder {

    @Override
    public VideoType type() {
        return VideoType.WMV;
    }

    @Override
    public void decode() {
        System.out.println("WMVDecoder decode");
    }
}
