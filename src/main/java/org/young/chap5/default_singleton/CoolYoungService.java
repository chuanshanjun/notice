package org.young.chap5.default_singleton;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:ChuanShanJun
 * @date:2021/2/21
 * @description:
 */
@Slf4j
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE) // bean默认是单例, 如果用原型就每请求一次都会实例化一个新的Bean
public class CoolYoungService {

    private List<String> youngs;

    @PostConstruct
    public void init() {
        log.info("coming in YoungSerice init");
        youngs = new ArrayList<>(100);
    }

    public void add(String value) {
        youngs.add(value);
    }

    public int count() {
        return youngs.size();
    }

    public List<String> get() {
        return youngs;
    }
}
