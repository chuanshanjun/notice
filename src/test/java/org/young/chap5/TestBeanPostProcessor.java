package org.young.chap5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.bean_post_processor.*;
import org.young.chap5.util.ApplicationUtils;

import java.util.Random;

/**
 * @author:ChuanShanJun
 * @date:2021/2/23
 * @description:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBeanPostProcessor {

    @Autowired
    private AVIDecoder aviDecoder;

    @Autowired
    private WMVDecoder wmvDecoder;

    @Autowired
    private DecoderManager decoderManager;

    @Test
    public void testBeanFactoryPostProcessor() {
        ThirdPartClass bean1 = ApplicationUtils.getBean(ThirdPartClass.class);
        ThirdPartClass bean2 = ApplicationUtils.getBean(ThirdPartClass.class);
        System.out.println(bean1.hashCode());
        System.out.println(bean2.hashCode());
    }

    @Test
    public void testEasyUseDecoder2() {
        IDecoder iDecoder = decoderManager
                .getIDecoder(VideoType.values()[new Random().nextInt(VideoType.values().length)]);
        iDecoder.decode();
    }

    @Test
    public void testEasyUseDecoder() {
        VideoType type = getDecoderType();

        switch (type) {
            case AVI:
                aviDecoder.decode();
            case WMV:
                wmvDecoder.decode();
            default:
                log.info("error");
        }
    }

    private VideoType getDecoderType() {
        return VideoType.values()[new Random().nextInt(VideoType.values().length)];
    }
}
