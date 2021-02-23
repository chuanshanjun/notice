package org.young.chap5.bean_post_processor;

import org.springframework.stereotype.Service;

/**
 * @author:ChuanShanJun
 * @date:2021/2/23
 * @description:
 */
@Service
public class AVIDecoder implements IDecoder {

    @Override
    public VideoType type() {
        return VideoType.AVI;
    }

    @Override
    public void decode() {
        System.out.println("AVIDecoder decode");
    }
}
