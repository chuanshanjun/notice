package org.young.chap5.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:ChuanShanJun
 * @date:2021/2/23
 * @description:
 */
@Slf4j
@Service
public class DecoderManager implements BeanPostProcessor {

    private static Map<VideoType, IDecoder> videoTypeIndex = new HashMap<>(VideoType.values().length);

    public IDecoder getIDecoder(VideoType type) {

        switch (type) {
            case WMV:
                return videoTypeIndex.get(VideoType.WMV);
            case AVI:
                return videoTypeIndex.get(VideoType.AVI);
            default:
                return null;
        }

    }

    /**
     * <h2>BeanPostProcessor实例化时，
     * 自动依赖注入根据类型获得需要注入的Bean时，
     * 会将某些符合条件的Bean先实例化，
     * 如果此FacotryBean又依赖其他普通Bean，
     * 会导致该Bean提前启动，
     * 造成"误伤"（无法享受部分BeanPostProcessor的后置处理，例如典型的auto-proxy）。</h2>
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof IDecoder)) {
            return bean;
        }

        IDecoder iDecoder = (IDecoder) bean;
        VideoType type = iDecoder.type();

        log.info("DecoderManager postProcessBeforeInitialization()");

        if (videoTypeIndex.containsKey(type)) {
            log.info("iDecoder.type() exist");
            return bean;
        }

        videoTypeIndex.put(type, iDecoder);

        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof IDecoder)) {
            return bean;
        }

        log.info("DecoderManager postProcessAfterInitialization()");
        return null;
    }
}
